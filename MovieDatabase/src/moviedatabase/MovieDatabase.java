package moviedatabase;

import moviedatabase.cli.Cli;
import moviedatabase.exception.CommandException;
import moviedatabase.exception.EmptyCommandException;
import moviedatabase.io.File;
import moviedatabase.io.Prompt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class MovieDatabase {
    private final File databaseFile;
    private final ArrayList<Movie> movies;

    public MovieDatabase(String fileName) throws IOException {
        databaseFile = new File(fileName);
        String contents = databaseFile.read();

        movies = new ArrayList<>();
        StringTokenizer entries = new StringTokenizer(contents, "\n");
        while (entries.hasMoreTokens()) {
            String entry = entries.nextToken();
            Movie movie = Movie.parse(entry);
            movies.add(movie);
        }
    }

    public void startCli() {
        Cli<MovieCommand> cli = new Cli<>(MovieCommand.class);

        while (true) {
            MovieCommand command;
            try {
                command = cli.getNextCommand();
            } catch (EmptyCommandException e) {
                continue;
            } catch (CommandException e) {
                System.out.println("Command error: " + e.getMessage());
                System.out.println("Type \"help\" to get help.");
                continue;
            }

            switch (command) {
                case NEW:
                    createNewMovie();
                    break;
                case SEARCH_ACTOR:
                    String actor = Prompt.promptString("Search by actor:");
                    ArrayList<Movie> actorMatches = search(movie -> movie.getActor1().toLowerCase().equals(actor)
                            || movie.getActor2().toLowerCase().equals(actor));
                    if (actorMatches.isEmpty())
                        System.out.println("No movies found with actor " + actor + ".");
                    else
                        for (Movie movie : actorMatches)
                            System.out.println(movie.getTitle());
                    break;
                case SEARCH_YEAR:
                    int year = Prompt.promptInt("Search by year:");
                    ArrayList<Movie> yearMatches = search(movie -> movie.getYear() == year);
                    if (yearMatches.isEmpty())
                        System.out.println("No movies found in year " + year + ".");
                    else
                        for (Movie movie : yearMatches)
                            System.out.println(movie.getTitle());
                    break;
                case SEARCH_RUNTIME:
                    int runtime = Prompt.promptInt("Search by runtime:");
                    ArrayList<Movie> runtimeMatches = search(movie -> movie.getRuntime() == runtime);
                    if (runtimeMatches.isEmpty())
                        System.out.println("No movies found with " + runtime + " minutes of runtime.");
                    else
                        for (Movie movie : runtimeMatches)
                            System.out.println(movie.getTitle());
                    break;
                case SEARCH_DIRECTOR:
                    String director = Prompt.promptString("Search by director:");
                    ArrayList<Movie> directorMatches = search(movie -> movie.getDirector().toLowerCase().equals(director));
                    if (directorMatches.isEmpty())
                        System.out.println("No movies found directed by " + director + ".");
                    else
                        for (Movie movie : directorMatches)
                            System.out.println(movie.getTitle());
                    break;
                case SEARCH_TITLE:
                    String title = Prompt.promptString("Search by title:");
                    ArrayList<Movie> titleMatches = search(movie -> movie.getTitle().toLowerCase().equals(title));
                    if (titleMatches.isEmpty())
                        System.out.println("No movies found with title \"" + title + "\".");
                    else
                        for (Movie movie : titleMatches)
                            System.out.println(movie);
                    break;
                case DELETE:
                    String titleToDelete = Prompt.promptString("Enter title to delete:");
                    deleteMovieByTitle(titleToDelete);
                    break;
                case EXIT:
                    return;
                case HELP:
                    StringBuilder res = new StringBuilder();
                    for (MovieCommand helpCommand : MovieCommand.values())
                        res.append("\t").append(helpCommand.toString().toLowerCase()).append(" - ").append(helpCommand.getDescription()).append("\n");

                    System.out.print(res);
                    break;
            }
        }
    }

    private void deleteMovieByTitle(String title) {
        int i = 0;
        while (i < movies.size()) {
            Movie movie = movies.get(i);
            String movieTitle = movie.getTitle();
            if (movieTitle.toLowerCase().equals(title)) {
                movies.remove(i);

                StringBuilder res = new StringBuilder();
                for (Movie otherMovie : movies)
                    res.append(otherMovie.serialize()).append("\n");

                try {
                    databaseFile.write(res.toString().trim());
                } catch (IOException e) {
                    System.out.println("Failed to save movie database to \"" + databaseFile.getFileName() + "\".");
                    return;
                }

                System.out.println("Removed \"" + movieTitle + "\".");
                return;
            }
            i++;
        }

        System.out.println("No movie found with title \"" + title + "\".");
    }

    private ArrayList<Movie> search(Predicate<Movie> predicate) {
        ArrayList<Movie> matches = new ArrayList<>();
        for (Movie movie : movies)
            if (predicate.test(movie))
                matches.add(movie);
        return matches;
    }

    private void createNewMovie() {
        String title = Prompt.promptString("What is the movie's title?");
        int year = Prompt.promptInt("What year was the movie made?");
        int runtime = Prompt.promptInt("What is the movie's runtime (in minutes)?");
        String actor1 = Prompt.promptString("Enter actor1.");
        String actor2 = Prompt.promptString("Enter actor2.");
        String director = Prompt.promptString("Who was the director?");

        Movie newMovie = new Movie(title, year, runtime, actor1, actor2, director);

        movies.add(newMovie);
        try {
            databaseFile.append(newMovie.serialize());
        } catch (IOException e) {
            System.out.println("Failed to save movie database to \"" + databaseFile.getFileName() + "\".");
            return;
        }

        System.out.println("Saved new movie \"" + title + "\".");
    }

    public void displayTitle() {
        System.out.println("========================================");
        System.out.println("  M O V I E   D A T A B A S E   MK 500  ");
        System.out.println("========================================");
    }
}

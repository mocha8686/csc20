package moviedatabase;

import moviedatabase.cli.Description;

public enum MovieCommand implements Description {
    NEW("Add a new movie to the database."),
    SEARCH_ACTOR("Search movies by actors."),
    SEARCH_YEAR("Search movies by year."),
    SEARCH_RUNTIME("Search movies by runtime (in minutes)."),
    SEARCH_DIRECTOR("Search movies by director."),
    SEARCH_TITLE("Search movies by title."),
    DELETE("Delete a movie by title."),
    EXIT("Exits the program."),
    HELP("Print all commands.");

    private final String description;

    MovieCommand(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

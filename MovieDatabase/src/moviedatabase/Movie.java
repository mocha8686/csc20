package moviedatabase;

import moviedatabase.exception.InvalidEntryException;

import java.util.StringTokenizer;

public class Movie {
    public static final String DELIMITER = "*";

    private final String title;
    private final int year;
    private final int runtime;
    private final String actor1;

    private final String actor2;
    private final String director;

    public Movie(String title, int year, int runtime, String actor1, String actor2, String director) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.director = director;
    }

    public static Movie parse(String entry) {
        StringTokenizer tokenizer = new StringTokenizer(entry, DELIMITER);
        if (tokenizer.countTokens() < 6) {
            throw new InvalidEntryException("Not enough fields");
        }

        String title = tokenizer.nextToken().trim();

        int year;
        try {
            String yearToken = tokenizer.nextToken().trim();
            year = Integer.parseInt(yearToken);
        } catch (NullPointerException e) {
            throw new InvalidEntryException("Field \"year\" is not a valid number");
        }

        int runtime;
        try {
            String runtimeToken = tokenizer.nextToken().trim();
            runtime = Integer.parseInt(runtimeToken);
        } catch (NullPointerException e) {
            throw new InvalidEntryException("Field \"runtime\" is not a valid number");
        }

        String actor1 = tokenizer.nextToken().trim();
        String actor2 = tokenizer.nextToken().trim();

        String director = tokenizer.nextToken().trim();

        return new Movie(title, year, runtime, actor1, actor2, director);
    }

    public String serialize() {
        return title + DELIMITER + year + DELIMITER + runtime + DELIMITER + actor1 + DELIMITER + actor2 + DELIMITER + director;
    }

    public int getYear() {
        return year;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getTitle() {
        return title;
    }

    public String getActor1() {
        return actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Actors: " + actor1 + ", " + actor2 + "\nDirector: " + director + "\nYear: " + year + "\nRuntime: " + runtime;
    }
}

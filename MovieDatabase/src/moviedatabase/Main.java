package moviedatabase;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MovieDatabase movieDatabase;
        try {
            movieDatabase = new MovieDatabase("db.txt");
        } catch (IOException e) {
            System.err.println("Failed to load db.txt.");
            return;
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        movieDatabase.displayTitle();
        movieDatabase.startCli();
    }
}

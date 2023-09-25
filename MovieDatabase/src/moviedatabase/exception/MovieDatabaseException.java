package moviedatabase.exception;

public class MovieDatabaseException extends RuntimeException {
    public MovieDatabaseException(String message) {
        super(message);
    }

    public MovieDatabaseException() {
        super();
    }
}

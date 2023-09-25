package moviedatabase.exception;

public class InvalidEntryException extends MovieDatabaseException {
    public InvalidEntryException(String message) {
        super(message);
    }

    public InvalidEntryException() {
        super();
    }
}

package moviedatabase.exception;

public class CommandException extends MovieDatabaseException {
    public CommandException(String message) {
        super(message);
    }

    public CommandException() {
        super();
    }
}

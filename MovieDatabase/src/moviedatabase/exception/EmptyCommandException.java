package moviedatabase.exception;

public class EmptyCommandException extends CommandException {
    public EmptyCommandException(String message) {
        super(message);
    }

    public EmptyCommandException() {
        super();
    }
}

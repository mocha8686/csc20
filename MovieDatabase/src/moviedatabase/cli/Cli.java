package moviedatabase.cli;

import moviedatabase.exception.CommandException;
import moviedatabase.exception.EmptyCommandException;
import moviedatabase.io.Keyboard;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Cli<T extends Enum<T> & Description> {
    private final Class<T> typeArgumentClass;

    public Cli(Class<T> typeArgumentClass) {
        this.typeArgumentClass = typeArgumentClass;
    }

    public T getNextCommand() {
        String input = Keyboard.getNextLine("> ");
        StringTokenizer tokenizer = new StringTokenizer(input, " ");

        String commandName;
        try {
            commandName = tokenizer.nextToken();
        } catch (NoSuchElementException e) {
            throw new EmptyCommandException();
        }

        try {
            return T.valueOf(typeArgumentClass, commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CommandException("No such command \"" + commandName + "\"");
        }
    }
}

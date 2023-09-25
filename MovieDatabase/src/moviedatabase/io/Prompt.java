package moviedatabase.io;

public class Prompt {
    public static String promptString(String prompt) {
        System.out.println(prompt);
        return Keyboard.getNextLine("? ");
    }

    public static int promptInt(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                return Integer.parseInt(Keyboard.getNextLine("? "));
            } catch (NumberFormatException e) {
                System.out.println("Not a number.");
            }
        }
    }
}

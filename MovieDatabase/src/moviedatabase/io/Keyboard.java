package moviedatabase.io;

import java.util.Scanner;

public class Keyboard {
    public static String getNextLine(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim().toLowerCase();
    }
}

package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greetings() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        String userName = input.nextLine();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
}

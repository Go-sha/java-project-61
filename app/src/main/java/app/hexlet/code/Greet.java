package hexlet.code;

import java.util.Scanner;

public class Greet {
    public static String startGame() {
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = input.nextLine();

        return "Hello, " + userName + "!";
    }
}

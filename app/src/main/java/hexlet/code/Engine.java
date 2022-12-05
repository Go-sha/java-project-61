package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class Engine {
    public static final int ATT = 3; /*< number of wrong attempts */
    public static final int SHORT_RANDOM_RANGE = 20;
    public static final int MIDDLE_RANDOM_RANGE = 50;
    public static final int LONG_RANDOM_RANGE = 100;
    public static void start(String gameName) {
        String userName;

        if (gameName.equals("Exit")) {
            return;
        }

        if (gameName.equals("Greet")) {
            greetUser();
            return;
        }

        userName = greetUser();
        if (userName == null) {
            return;
        }

        printRules(gameName);

        for (int i = 0; i < ATT; i++) {
            if (!runOneIteration(gameName)) {
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }
        }

        System.out.printf("Congratulations, %s!\n", userName);
    }

    private static String greetUser() {
        Scanner input = new Scanner(System.in);
        String userName;
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        userName = input.nextLine();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    private static void printRules(String gameName) {
        switch (gameName) {
            case "Even":
                System.out.println(Even.getRules());
                break;
            case "Calc":
                System.out.println(Calc.getRules());
                break;
            case "GCD":
                System.out.println(Gcd.getRules());
                break;
            case "Progression":
                System.out.println(Progression.getRules());
                break;
            case "Prime":
                System.out.println(Prime.getRules());
                break;
            default:
                throw new java.lang.IllegalStateException("Unexpected value: " + gameName);
        }
    }

    private static boolean runOneIteration(String gameName) {
        Scanner input = new Scanner(System.in);
        String question = "Question: ";
        String correctAnswer = null;
        String userAnswer;

        switch (gameName) {
            case "Even":
                Even even = new Even();

                correctAnswer = even.getAnswer();
                question += even.getQuestion();
                break;
            case "Calc":
                Calc calc = new Calc();

                correctAnswer = calc.getAnswer();
                question += calc.getQuestion();
                break;
            case "GCD":
                Gcd gcd = new Gcd();

                correctAnswer = gcd.getAnswer();
                question += gcd.getQuestion();
                break;
            case "Progression":
                Progression progression = new Progression();

                correctAnswer = progression.getAnswer();
                question += progression.getQuestion();
                break;
            case "Prime":
                Prime prime = new Prime();

                correctAnswer = prime.getAnswer();
                question += prime.getQuestion();
                break;
            default:
                throw new java.lang.IllegalStateException("Unexpected value: " + gameName);
        }

        System.out.println(question);
        System.out.print("Your answer: ");
        userAnswer = input.nextLine();

        return isAnswerCorrect(correctAnswer, userAnswer);

    }

    public static boolean isAnswerCorrect(String correctAnswer, String userAnswer) {
        if (correctAnswer.equals(userAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is wrong Answer ;(. Correct answer was '%s'.\n",
                              userAnswer, correctAnswer);
            return false;
        }
    }
}


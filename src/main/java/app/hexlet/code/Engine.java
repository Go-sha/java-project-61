package hexlet.code;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class Engine {
    public static final int ATT = 3; /*< number of wrong attempts */
    public static final String[][] GAMES = {
        {"1", "Greet"},
        {"2", "Even"},
        {"3", "Calc"},
        {"4", "GCD"},
        {"5", "Progression"},
        {"6", "Prime"},
        {"0", "Exit"}
    };

    /* This method checks that entered answer is correct or not. */
    public static boolean isCorrect(String correctAnswer, String userName) {
        Scanner input = new Scanner(System.in);
        System.out.print("Your answer: ");
        var answer = input.nextLine();

        if (!answer.equals(correctAnswer)) {
            System.out.println("'" + answer + "' is wrong answer ;(. "
                               + "Correct answer was '" + correctAnswer + "'");
            System.out.println("Let's try again, " + userName + "!");

            return false;
        } else {
            System.out.println("Correct!");
            return true;
        }
    }

    /* This method chooses game according to id that was entered by the user. */
    public static String chooseGame() {
        int numberOfAttempts = 0;
        String gameName = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        for (var game : Engine.GAMES) {
            System.out.println(game[0] + " - " + game[1]);
        }

        while (gameName == null && numberOfAttempts < Engine.ATT) {
            if (numberOfAttempts != 0) {
                System.out.println("Wrong. Please enter correct number.");
            }
            System.out.print("Your choice: ");
            String gameId = input.nextLine();

            for (var game : Engine.GAMES) {
                if (game[0].equals(gameId)) {
                    gameName = game[1];
                    break;
                }
            }

            numberOfAttempts++;
        }

        if (gameName == null) {
            System.out.println("Too many attempts to enter correct id of the game");
        }
        return gameName;
    }

    public static void startRealGame(String gameName, String userName) {

        try {
            Class cls = Class.forName("hexlet.code." + gameName);
            Object obj = cls.newInstance();

            Method startGame = cls.getMethod("startGame", String.class);
            Object retValue = startGame.invoke(obj, userName);
            if ((boolean) retValue) {
                System.out.println("Congratulations, " + userName + "!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (NoSuchMethodException e) {
            System.out.println(e.toString());
        } catch (InstantiationException e) {
            System.out.println(e.toString());
        } catch (IllegalAccessException e) {
            System.out.println(e.toString());
        } catch (InvocationTargetException e) {
            System.out.println(e.toString());
        }
    }

    /* This method starts the game that the user want to play.
     * It uses method startGame that every game class must have.
     */
    public static void startGame(String gameName) {
        final String className = "hexlet.code.games";

        if (gameName == "Exit") {
            return;
        }

        String userName = Cli.greetings();
        if (gameName == "Greet") {
            return;
        }

        gameName = gameName.substring(0, 1).toUpperCase()
                   + gameName.substring(1).toLowerCase();

        Engine.startRealGame(gameName, userName);
    }
}

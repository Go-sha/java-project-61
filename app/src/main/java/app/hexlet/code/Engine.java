package hexlet.code;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class Engine {
    public static final int ATT = 3; /*< number of wrong attempts */

    public static Method[] getGamesMethods() {
        Games gamesObj = new Games();
        Class gamesClass = gamesObj.getClass();

        return gamesClass.getDeclaredMethods();
    }

    public static String[][] getGameList() {
        Method[] methods = Engine.getGamesMethods();
        String[][] games = new String[methods.length + 2][2];
        int i = 1;

        games[0][0] = "1";
        games[0][1] = "Greet";
        for (var method : methods) {
            var methodStr = method.getName();
            games[i][0] = Integer.toString(i + 1);
            games[i][1] = methodStr.substring(0, 1).toUpperCase()
                          + methodStr.substring(1);
            i++;
        }
        games[i][0] = "0";
        games[i][1] = "Exit";

        return games;
    }
    public static boolean isCorrect(String correctAnswer, String userName) {
        Scanner input = new Scanner(System.in);
        System.out.print("Your anser: ");
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

    public static String chooseGame() {
        final String[][] games = getGameList();
        int numberOfAttempts = 0;
        String gameName = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");

        for (var game : games) {
            System.out.println(game[0] + " - " + game[1]);
        }

        while (gameName == null && numberOfAttempts < Engine.ATT) {
            if (numberOfAttempts != 0) {
                System.out.println("Wrong. Please enter correct number.");
            }
            System.out.print("Your choice: ");
            String gameId = input.nextLine();

            for (var game : games) {
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

    public static void startGame(String gameName) {
        final String className = "hexlet.code.Games";

        if (gameName == "Exit") {
            return;
        }

        String userName = Cli.greetings();

        if (gameName == "Greet") {
            return;
        }

        Method[] methods = Engine.getGamesMethods();

        for (var method : methods) {
            if (method.getName().equals(gameName.toLowerCase())) {
                try {
                    if((boolean) method.invoke(new Games(), userName)) {
                        System.out.println("Congratulations, " + userName + "!");
                    }

                /* handle exceptions for invoke() */
                } catch (IllegalAccessException e) {
                    System.out.println(e.toString());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.toString());
                } catch (InvocationTargetException e) {
                    System.out.println(e.toString());
                }
                return;
            }
        }
    }
}

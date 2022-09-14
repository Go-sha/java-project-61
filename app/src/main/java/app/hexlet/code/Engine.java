package hexlet.code;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class Engine {
    public static final int ATT = 3; /*< number of wrong attempts */

    /* This method find all methods from class Games that do not have
     * hide in their names. */
    public static Method[] getGamesMethods() {
        int retvalLength = 0;
        Games gamesObj = new Games();
        Class gamesClass = gamesObj.getClass();
        Method[] methodsExtended = gamesClass.getDeclaredMethods();
        Method[] methods = new Method[methodsExtended.length];

        for (var method : methodsExtended) {
            if (!method.getName().contains("hide")) {
                methods[retvalLength] = method;
                retvalLength++;
            }
        }
        Method[] retval = new Method[retvalLength];

        for (int i = 0; i < retval.length; i++) {
            retval[i] = methods[i];
        }

        return retval;
    }

    /* This method makes string array ordered by method ID
     * with names of the methods from getGamesMethods()(i.e. names of the games)
     * and their IDs. It also adds Greet and Exit to that array.
     */
    public static String[][] getGameList() {
        Method[] methods = Engine.getGamesMethods();
        String[][] games = new String[methods.length + 2][2];
        int i = 1;

        games[0][0] = "1";
        games[0][1] = "Greet";
        for (var method : methods) {
            GamesAnno gAnno = method.getAnnotation(GamesAnno.class);
            games[Integer.parseInt(gAnno.id()) - 1][0] = gAnno.id();
            games[Integer.parseInt(gAnno.id()) - 1][1] = gAnno.name();
        }
        games[games.length - 1][0] = "0";
        games[games.length - 1][1] = "Exit";

        return games;
    }
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

    /* This method calls method with the game that the user wanna play */
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
            GamesAnno gAnno = method.getAnnotation(GamesAnno.class);
            if (gAnno.name().equals(gameName)) {
                try {
                    if ((boolean) method.invoke(new Games(), userName)) {
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

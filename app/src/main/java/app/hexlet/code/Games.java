package hexlet.code;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class Games {
    public static String chooseGame() {
        final String[][] games = {
            {"1", "Greet"},
            {"2", "Even"},
            {"0", "Exit"}
        };
        final var numberOfWrongAttempts = 3;
        int numberOfAttempts = 0;
        String gameId;
        String className = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");

        for (var game : games) {
            System.out.println(game[0] + " - " + game[1]);
        }

        while (className == null && numberOfAttempts < numberOfWrongAttempts) {
            if (numberOfAttempts != 0) {
                System.out.println("Wrong. Please enter correct number.");
            }
            System.out.print("Your choice: ");
            gameId = input.nextLine();

            for (var game : games) {
                if (game[0].equals(gameId)) {
                    className = game[1];
                    break;
                }
            }

            numberOfAttempts++;
        }

        if (className == null) {
            System.out.println("Too many attempts to enter correct id of the game");
        }
        return className;
    }

    public static void startGame(String gameName) {
        Method method;
        String className = "hexlet.code." + gameName;
        String userName;

        if (gameName == "Exit") {
            return;
        }

        userName = Cli.greetings();

        if (gameName == "Greet") {
            return;
        }

        try {
            Class<?> cls = Class.forName(className);
            try {
                Object clsObj = cls.newInstance();
                try {
                    Method m = cls.getMethod("startGame", String.class);
                    try {
                        m.invoke(clsObj, userName);

                    /* handle exceptions for invoke() */
                    } catch (IllegalAccessException e) {
                        System.out.println(e.toString());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.toString());
                    } catch (InvocationTargetException e) {
                        System.out.println(e.toString());
                    }

                /* handle exceptions for getMethod() */
                } catch (NoSuchMethodException e) {
                    System.out.println(e.toString());
                }

            /* handle exceptions for newInstacne() */
            } catch (InstantiationException e) {
                System.out.println(e.toString());
            } catch (IllegalAccessException e) {
                System.out.println(e.toString());
            }

        /* handle exceptions for forName() */
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}

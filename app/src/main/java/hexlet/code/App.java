package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Integer EXIT = 0;
    private static final Integer GREET = 1;
    private static final Integer EVEN = 2;
    private static final Integer CALC = 3;
    private static final Integer GCD = 4;
    private static final Integer PROGRESSION = 5;
    private static final Integer PRIME = 6;

    public static void main(String[] args) {
        String gameName;
        Map<Integer, String> games = new LinkedHashMap<>();

        games.put(GREET, "Greet");
        games.put(EVEN, "Even");
        games.put(CALC, "Calc");
        games.put(GCD, "GCD");
        games.put(PROGRESSION, "Progression");
        games.put(PRIME, "Prime");
        games.put(EXIT, "Exit");

        gameName = chooseGame(games);
        if (gameName == null) {
            return;
        }

        Engine.start(gameName);
    }

    public static String chooseGame(Map<Integer, String> games) {
        String gameName = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        for (Map.Entry<Integer, String> entry: games.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.print("Your choice: ");
        int gameId = Integer.parseInt(input.nextLine());

        for (Map.Entry<Integer, String> entry: games.entrySet()) {
            if (gameId == entry.getKey()) {
                gameName = entry.getValue();
                break;
            }
        }
        return gameName;
    }
}

package hexlet.code;

public class App {

    public static void main(String[] args) {
        String gameName = null;

        gameName = Games.chooseGame();
        if (gameName != null) {
            Games.startGame(gameName);
        }
    }
}

package hexlet.code;

public class App {

    public static void main(String[] args) {
        String gameName = null;

        gameName = Engine.chooseGame();
        if (gameName != null) {
            Engine.startGame(gameName);
        }
    }
}

package hexlet.code.games;

import hexlet.code.Engine;

public final class Even {
    private int random;

    public static String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public int getQuestion() {
        return this.random;
    }

    public String getAnswer() {
        this.random = (int) (Math.random() * Engine.LONG_RANDOM_RANGE);
        return (random % 2) == 0 ? "yes" : "no";
    }
}

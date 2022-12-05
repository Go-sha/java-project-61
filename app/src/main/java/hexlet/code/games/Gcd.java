package hexlet.code.games;

import hexlet.code.Engine;

public final class Gcd {
    private int firstRandom;
    private int secondRandom;

    public static String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    public String getQuestion() {
        return this.firstRandom + " " + this.secondRandom;
    }

    public String getAnswer() {
        int result;
        this.firstRandom = (int) (Math.random() * Engine.MIDDLE_RANDOM_RANGE);
        this.secondRandom = (int) (Math.random() * Engine.MIDDLE_RANDOM_RANGE);

        result = euclideanAlg(Math.max(this.firstRandom, this.secondRandom),
                              Math.min(this.firstRandom, this.secondRandom));
        return Integer.toString(result);
    }
    public int euclideanAlg(int a, int b) {
        if (b == 0) {
            return a;
        }
        return euclideanAlg(b, a % b);
    }
}

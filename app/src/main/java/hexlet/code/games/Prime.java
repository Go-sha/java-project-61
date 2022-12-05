package hexlet.code.games;

import hexlet.code.Engine;
public final class Prime {
    private int number;

    public static String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public int getQuestion() {
        return this.number;
    }
    public String getAnswer() {
        number = (int) (Math.random() * Engine.LONG_RANDOM_RANGE);

        return isPrime(number) ? "yes" : "no";
    }

    public boolean isPrime(int n) {
        final int firstPrime = 1;
        final int lastPrime = 3;
        final int start = 2;

        if (n == 0) {
            return false;
        }
        if (n >= firstPrime && n <= lastPrime) {
            return true;
        }

        for (int i = start; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;

    }
}

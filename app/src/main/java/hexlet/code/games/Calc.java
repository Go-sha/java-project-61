package hexlet.code.games;

import hexlet.code.Engine;

public final class Calc {
    private int firstRandom;
    private int secondRandom;
    private String operator;

    public static String getRules() {
        return "What is the result of the expression?";
    }
    public String getQuestion() {
        return firstRandom + operator + secondRandom;
    }

    public String getAnswer() {
        final int opRange = 3;
        int op = (int) (Math.random() * opRange);

        this.firstRandom = (int) (Math.random() * Engine.SHORT_RANDOM_RANGE);
        this.secondRandom = (int) (Math.random() * Engine.SHORT_RANDOM_RANGE);

        switch (op) {
            case 0:
                this.operator = " + ";
                return Integer.toString(this.firstRandom + this.secondRandom);
            case 1:
                this.operator = " - ";
                return Integer.toString(this.firstRandom - this.secondRandom);
            case 2:
                this.operator = " * ";
                return Integer.toString(this.firstRandom * this.secondRandom);
            default:
                System.out.println("wrong operator");
                return null;
        }
    }
}

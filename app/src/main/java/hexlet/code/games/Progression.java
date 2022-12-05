package hexlet.code.games;

import hexlet.code.Engine;

public final class Progression {
    private String progression;

    public static String getRules() {
        return "What number is missing in the progression?";
    }

    public String getQuestion() {
        return progression;
    }

    public String getAnswer() {
        final int amountOfElements = 10;
        int base = (int) (Math.random() * Engine.SHORT_RANDOM_RANGE);
        int step = (int) (Math.random() * Engine.SHORT_RANDOM_RANGE);
        int missedElementPos = (int) (Math.random() * amountOfElements);
        int missedElement = 0;

        var result = new StringBuilder();

        for (int i = 0; i < amountOfElements; i++) {
            if (i == missedElementPos) {
                result.append(i == 0 ? ".." : " ..");
                missedElement = base;
            } else {
                result.append(i == 0 ? "" : " ");
                result.append(base);
            }
            base += step;
        }
        progression = result.toString();
        return Integer.toString(missedElement);
    }
}

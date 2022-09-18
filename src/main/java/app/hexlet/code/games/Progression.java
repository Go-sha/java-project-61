package hexlet.code;

class Progression {
    public int printProgression() {
        final int randomRange = 20;
        final int amountOfElements = 10;

        int base = (int) (Math.random() * randomRange);
        int step = (int) (Math.random() * randomRange);
        int missedElementPos = (int) (Math.random() * amountOfElements);
        int missedElement = 0;

        var result = new StringBuilder();

        for (int i = 0; i < amountOfElements; i++) {
            if (i == missedElementPos) {
                result.append(" ..");
                missedElement = base;
            } else {
                result.append(" " + base);
            }
            base += step;
        }
        System.out.println(result.toString());
        return missedElement;
    }

    public boolean startGame(String userName) {
        final int randomRange = 20;
        final int amountOfElements = 10;

        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < Engine.ATT; i++) {
            System.out.print("Question:");
            int correctAnswer = printProgression();

            if (!Engine.isCorrect(Integer.toString(correctAnswer), userName)) {
                return false;
            }
        }
        return true;
    }
}

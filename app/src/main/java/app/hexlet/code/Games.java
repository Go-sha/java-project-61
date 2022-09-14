package hexlet.code;

class Games {
    /* 2 - Even */
    public boolean even(String userName) {
        final int randomRange = 100;
        String correctAnswer;

        System.out.println("Answer 'yes' if number even "
                           + "otherwise answer 'no'.");

        for (int i = 0; i < Engine.ATT; i++) {
            int random = (int) (Math.random() * randomRange);

            System.out.println("Question: " + random);
            correctAnswer = (random % 2) == 0 ? "yes" : "no";

            if (!Engine.isCorrect(correctAnswer, userName)) {
                return false;
            }
        }
        return true;
    }

    /* 3 - Calc */
    public boolean calc(String userName) {
        final int opRange = 3;
        final int randomRange = 20;
        String opStr;
        int correctAnswer;

        System.out.println("What is the result of the expression?");

        for (int i = 0; i < Engine.ATT; i++) {
            int fRndm = (int) (Math.random() * randomRange);
            int sRndm = (int) (Math.random() * randomRange);
            int op = (int) (Math.random() * opRange);

            switch (op) {
                case 0:
                    opStr = " + ";
                    correctAnswer = fRndm + sRndm;
                    break;

                case 1:
                    opStr = " - ";
                    correctAnswer = fRndm - sRndm;
                    break;

                case 2:
                    opStr = " * ";
                    correctAnswer = fRndm * sRndm;
                    break;

                default:
                    System.out.println("wrong operator");
                    return false;
            }

            System.out.println("Question: " + fRndm + opStr + sRndm);

            if (!Engine.isCorrect(Integer.toString(correctAnswer), userName)) {
                return false;
            }
        }
        return true;
    }

    public int hideEuclideanAlg(int a, int b) {
        if (b == 0) { 
            return a;
        }
        return hideEuclideanAlg(b, a % b);
    }

    /* 4 - GCD */
    public boolean GCD(String userName) {
        final int randomRange = 50;

        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < Engine.ATT; i ++) {
            int fRndm = (int) (Math.random() * randomRange);
            int sRndm = (int) (Math.random() * randomRange);

            System.out.println("Question: " + fRndm + " " + sRndm);
            int correctAnswer = hideEuclideanAlg(Math.max(fRndm, sRndm),
                                                 Math.min(fRndm, sRndm));

            if (!Engine.isCorrect(Integer.toString(correctAnswer), userName)) {
                return false;
            }

        }
        return true;
    }

    /* This method print progression without one element.
     *
     * @return missed element
     */
    public int hidePrintProgression() {
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

    /* 5 - Progression */
    public boolean progression(String userName) {
        final int randomRange = 20;
        final int amountOfElements = 10;

        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < Engine.ATT; i++) {
            System.out.print("Question:");
            int correctAnswer = hidePrintProgression();

            if (!Engine.isCorrect(Integer.toString(correctAnswer), userName)) {
                return false;
            }
        }
        return true;
    }
}

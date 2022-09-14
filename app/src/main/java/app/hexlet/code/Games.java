package hexlet.code;

class Games {
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
}

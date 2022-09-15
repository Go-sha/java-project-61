package hexlet.code;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* We need this annotation to keep the list of games in specific order */
@Retention(RetentionPolicy.RUNTIME)
@interface GamesAnno {
    String id(); /*< Game id. It  will be displayed in game menu */
    String name(); /*< Game name. */
}
/* All non-game methods must contain "hide" in them. It is needed to
 * filter out this methods, otherwise they going to ruin games start.
 */
class Games {

    @GamesAnno(id = "2", name = "Even")
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

    @GamesAnno(id = "3", name = "Calc")
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

    @GamesAnno(id = "4", name = "GCD")
    public boolean gcd(String userName) {
        final int randomRange = 50;

        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < Engine.ATT; i++) {
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

    @GamesAnno(id = "5", name = "Progression")
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

    @GamesAnno(id = "6", name = "Prime")
    public boolean prime(String userName) {
        final int randomRange = 100;

        System.out.println("Answer 'yes' if given number is prime. "
                           + "Otherwise answer 'no'.");

        for (int i = 0; i < Engine.ATT; i++) {
            String correctAnswer = "yes";
            int number = (int) (Math.random() * randomRange);
            System.out.println("Question: " + number);

            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    correctAnswer = "no";
                    break;
                }
            }

            if (!Engine.isCorrect(correctAnswer, userName)) {
                return false;
            }
        }
        return true;
    }
}

package hexlet.code;

class Gcd {
    public int euclideanAlg(int a, int b) {
        if (b == 0) {
            return a;
        }
        return euclideanAlg(b, a % b);
    }

    public boolean startGame(String userName) {
        final int randomRange = 50;

        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < Engine.ATT; i++) {
            int fRndm = (int) (Math.random() * randomRange);
            int sRndm = (int) (Math.random() * randomRange);

            System.out.println("Question: " + fRndm + " " + sRndm);
            int correctAnswer = euclideanAlg(Math.max(fRndm, sRndm),
                                                 Math.min(fRndm, sRndm));

            if (!Engine.isCorrect(Integer.toString(correctAnswer), userName)) {
                return false;
            }

        }
        return true;
    }
}

package hexlet.code;

class Prime {
    public boolean startGame(String userName) {
        final int randomRange = 100;

        System.out.println("Answer 'yes' if given number is prime. "
                           + "Otherwise answer 'no'.");

        for (int i = 0; i < Engine.ATT; i++) {
            String correctAnswer = "yes";
            int number = (int) (Math.random() * randomRange);
            System.out.println("Question: " + number);

            if (number == 1 || number == 2) {
                break;
            } else if (number == 0) {
                correctAnswer = "no";
                break;
            }
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

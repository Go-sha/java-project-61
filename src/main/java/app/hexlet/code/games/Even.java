package hexlet.code;

class Even {
    public boolean startGame(String userName) {
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
}

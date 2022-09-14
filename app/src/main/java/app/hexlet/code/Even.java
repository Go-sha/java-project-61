package hexlet.code;

import java.util.Scanner;

class Even {
    public void startGame(String userName) {
        final int numberOfAttempts = 3;
        final int randomRange = 100;
        String correctAnswer;
        String answer;
        Scanner input = new Scanner(System.in);

        System.out.println("Answer 'yes' if number even "
                           + "otherwise answer 'no'.");

        for (int i = 0; i < numberOfAttempts; i++) {
            int random = (int) (Math.random() * randomRange);

            System.out.println("Question: " + random);
            correctAnswer = (random % 2) == 0 ? "yes" : "no";

            answer = input.nextLine();
            System.out.println("Your answer: " + answer);

            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. "
                                + "Correct answer was '" + correctAnswer + "'");
                return;
            } else {
                System.out.println("Correct!");
            }

        }

        System.out.println("Congratulations, " + userName + "!");
    }
}

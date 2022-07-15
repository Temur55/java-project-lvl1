package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final int COUNT_OF_CHECK = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String[][] QUESTION_ANSWER_PAIRS = new String[COUNT_OF_CHECK][2];

    private static int currentPair = 0;

    public static int getCountOfCheck() {
        return COUNT_OF_CHECK;
    }
    public static void setQuestionAnswerPair(String question, String answer) {
        if (currentPair == COUNT_OF_CHECK) {
            return;
        }
        QUESTION_ANSWER_PAIRS[currentPair][0] = question;
        QUESTION_ANSWER_PAIRS[currentPair][1] = answer;
        currentPair += 1;
    }

    public static void run() {
        int currentQuestion;

        for (currentQuestion = 0; currentQuestion < COUNT_OF_CHECK; currentQuestion++) {
            String[] questionAnswerPair = QUESTION_ANSWER_PAIRS[currentQuestion];
            String question = questionAnswerPair[0];
            System.out.printf("Question: %s\n", question);
            System.out.print("Your answer: ");
            String answer = SCANNER.nextLine();
            String rightAnswer = questionAnswerPair[1];
            if (rightAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, rightAnswer);
                System.out.printf("Let's try again, %s!\n", Player.getName());
                break;
            }
        }
        if (currentQuestion < COUNT_OF_CHECK) {
            return;
        }

        System.out.printf("Congratulations, %s!", Player.getName());
    }
}

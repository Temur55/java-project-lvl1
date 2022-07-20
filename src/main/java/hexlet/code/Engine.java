package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final int COUNT_OF_CHECK = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String playerName;

    public static int getCountOfCheck() {
        return COUNT_OF_CHECK;
    }

    public static void callIntro(String gameRule) {
        System.out.println("\nWelcome to the Brain Games!");

        System.out.print("May I have your name? ");

        playerName = SCANNER.nextLine();

        System.out.printf("Hello, %s!\n", playerName);

        if (gameRule != null) {
            System.out.println(gameRule);
        }
    }

    public static void run(String[][] questionAnswerPairs) {
        int currentQuestion;

        for (currentQuestion = 0; currentQuestion < COUNT_OF_CHECK; currentQuestion++) {
            String[] questionAnswerPair = questionAnswerPairs[currentQuestion];
            String question = questionAnswerPair[0];
            System.out.printf("Question: %s\n", question);
            System.out.print("Your answer: ");
            String answer = SCANNER.nextLine();
            String rightAnswer = questionAnswerPair[1];
            if (!rightAnswer.equals(answer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, rightAnswer);
                System.out.printf("Let's try again, %s!\n", playerName);
                return;
            }
            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!", playerName);
    }
}

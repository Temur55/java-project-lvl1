package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class GcdGame {
    private static final Random RANDOMIZER = new Random();
    private static final Integer MAX_RANDOM_NUMBER = 100;
    private static final Integer MIN_RANDOM_NUMBER = 2;

    public static String getName() {
        return "GCD";
    };

    public static void play() {
        String[][] questionAnswerPair = new String[Engine.getCountOfCheck()][2];
        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            questionAnswerPair[i] = generateQuestionAnswerPair();
        }

        Engine.run("Find the greatest common divisor of given numbers.", questionAnswerPair);
    }

    private static String[] generateQuestionAnswerPair() {
        int leftNumber = RANDOMIZER.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int rightNumber = RANDOMIZER.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "%s %s".formatted(leftNumber, rightNumber);
        questionAnswerPair[1] = calculateAnswer(leftNumber, rightNumber);

        return questionAnswerPair;
    }

    private static String calculateAnswer(int left, int right) {
        while (left != right) {
            if (left > right) {
                int buffer = left;
                left = right;
                right = buffer;
            }
            right = right - left;
        }
        return String.valueOf(left);
    }
}

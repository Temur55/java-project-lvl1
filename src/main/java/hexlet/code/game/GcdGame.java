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
        System.out.println("Find the greatest common divisor of given numbers.");

        String question;

        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            question = generateQuestion();
            Engine.setQuestionAnswerPair(question, calculateAnswer(question));
        }
        Engine.run();
    }

    private static String generateQuestion() {
        return "%s %s".formatted(String.valueOf(RANDOMIZER.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)),
                String.valueOf(RANDOMIZER.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)));
    }

    private static String calculateAnswer(String question) {
        String[] operands = question.split(" ");
        int left = Integer.parseInt(operands[0]);
        int right = Integer.parseInt(operands[1]);

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

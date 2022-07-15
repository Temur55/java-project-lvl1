package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class PrimeGame {
    private static final Random RANDOMIZER = new Random();

    private static final Integer MAX_RANDOM_NUMBER = 100;
    private static final Integer MIN_RANDOM_NUMBER = 2;

    public static String getName() {
        return "Prime";
    };

    public static void play() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String question;

        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            question = generateQuestion();
            Engine.setQuestionAnswerPair(question, calculateAnswer(question));
        }
        Engine.run();
    }

    private static String generateQuestion() {
        return String.valueOf(RANDOMIZER.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
    }

    private static String calculateAnswer(String question) {
        int number = Integer.parseInt(question);

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }
}

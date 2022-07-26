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
        String[][] questionAnswerPair = new String[Engine.getCountOfCheck()][2];
        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            questionAnswerPair[i] = generateQuestionAnswerPair();
        }

        Engine.run("Answer 'yes' if given number is prime. Otherwise answer 'no'.", questionAnswerPair);
    }

    private static String[] generateQuestionAnswerPair() {
        int number = RANDOMIZER.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = String.valueOf(number);
        questionAnswerPair[1] = calculateAnswer(number);

        return questionAnswerPair;
    }

    private static String calculateAnswer(int number) {

        boolean isPrime = isPrime(number);
        if (isPrime) {
            return "yes";
        }

        return "no";
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

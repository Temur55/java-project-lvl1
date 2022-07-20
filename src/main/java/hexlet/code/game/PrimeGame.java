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
        Engine.callIntro("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String question;
        String[][] questionAnswerPair = new String[Engine.getCountOfCheck()][2];
        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            question = generateQuestion();
            questionAnswerPair[i][0] = question;
            questionAnswerPair[i][1] = calculateAnswer(question);
        }
        Engine.run(questionAnswerPair);
    }

    private static String generateQuestion() {
        return String.valueOf(RANDOMIZER.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
    }

    private static String calculateAnswer(String question) {
        int number = Integer.parseInt(question);

        boolean isPrime = isPrime(number);
        if (isPrime) {
            return "yes";
        }

        return "no";
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

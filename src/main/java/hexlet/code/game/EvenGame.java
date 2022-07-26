package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class EvenGame {
    private static final Random RANDOMIZER = new Random();
    private static final Integer MAX_RANDOM_NUMBER = 100;

    public static String getName() {
        return "Even";
    };

    public static void play() {
        String[][] questionAnswerPair = new String[Engine.getCountOfCheck()][2];
        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            questionAnswerPair[i] = generateQuestionAnswerPair();
        }

        Engine.run("Answer 'yes' if the number is even, otherwise answer 'no'.", questionAnswerPair);
    }

    private static boolean checkNumberIsEven(int number) {
        return (number % 2 == 0);
    }

    private static String[] generateQuestionAnswerPair() {
        int number = RANDOMIZER.nextInt(MAX_RANDOM_NUMBER);
        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = String.valueOf(number);
        questionAnswerPair[1] = calculateAnswer(number);
        return questionAnswerPair;
    }

    private static String calculateAnswer(int number) {
        return checkNumberIsEven(number) ? "yes" : "no";
    }

}

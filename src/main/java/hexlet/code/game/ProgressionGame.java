package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class ProgressionGame {
    private static final Random RANDOMIZER = new Random();
    private static final Integer MAX_RANDOM_NUMBER = 100;
    private static final Integer MIN_STEP = 2;
    private static final Integer MAX_STEP = 10;
    private static final Integer MIN_LENGTH = 5;
    private static final Integer MAX_LENGTH = 10;

    public static String getName() {
        return "Progression";
    };

    public static void play() {
        String[][] questionAnswerPair = new String[Engine.getCountOfCheck()][2];
        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            questionAnswerPair[i] = calculateQuestionAnswerPair();
        }

        Engine.run("What number is missing in the progression?", questionAnswerPair);
    }

    private static String[] calculateQuestionAnswerPair() {
        int length = RANDOMIZER.nextInt(MIN_LENGTH, MAX_LENGTH);
        int step = RANDOMIZER.nextInt(MIN_STEP, MAX_STEP);

        Integer[] numbers = generateProgression(length, step);

        int indexOfGap = RANDOMIZER.nextInt(0, numbers.length);

        StringBuilder question = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (i == indexOfGap) {
                question.append("..");
            } else {
                question.append(numbers[i]);
            }
            question.append(" ");
        }

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = question.toString().strip();
        questionAnswerPair[1] = numbers[indexOfGap].toString();
        return questionAnswerPair;
    }

    private static Integer[] generateProgression(int length, int step) {
        Integer[] numbers = new Integer[length];
        numbers[0] = RANDOMIZER.nextInt(MAX_RANDOM_NUMBER);
        for (int i = 1; i < length; i++) {
            numbers[i] = numbers[i - 1] + step;
        }

        return numbers;
    }
}

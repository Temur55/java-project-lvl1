package hexlet.code.game;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
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
        System.out.println("What number is missing in the progression?");

        String question;

        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            question = generateQuestion();
            Engine.setQuestionAnswerPair(question, calculateAnswer(question));
        }
        Engine.run();
    }

    private static String generateQuestion() {
        int length = RANDOMIZER.nextInt(MIN_LENGTH, MAX_LENGTH);
        int step = RANDOMIZER.nextInt(MIN_STEP, MAX_STEP);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(RANDOMIZER.nextInt(MAX_RANDOM_NUMBER));
        for (int i = 0; i < length; i++) {
            numbers.add(numbers.get(i) + step);
        }

        numbers.set(RANDOMIZER.nextInt(length), null);

        StringBuilder question = new StringBuilder();

        for (Integer number : numbers) {

            if (number == null) {
                question.append("..");
            } else {
                question.append(number);
            }

            question.append(" ");
        }
        return question.toString().strip();
    }

    private static String calculateAnswer(String question) {
        List<String> numbers = List.of(question.split(" "));

        int indexOfGap = numbers.indexOf("..");

        if (indexOfGap == 0) {
            return String.valueOf(2 * Integer.parseInt(numbers.get(1))
                    - Integer.parseInt(numbers.get(2)));
        }

        if (indexOfGap == (numbers.size() - 1)) {
            return String.valueOf(2 * Integer.parseInt(numbers.get(indexOfGap - 1))
                    - Integer.parseInt(numbers.get(indexOfGap - 2)));
        }

        return String.valueOf((Integer.parseInt(numbers.get(indexOfGap - 1))
                + Integer.parseInt(numbers.get(indexOfGap + 1))) / 2);
    }
}

package hexlet.code.game;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ProgressionGame implements Game {
    private final Random randomizer = new Random();
    private final Engine engine;
    private final Integer maxRandomNumber = 100;
    private final Integer minStep = 2;
    private final Integer maxStep = 10;
    private final Integer minLength = 5;
    private final Integer maxLength = 10;

    public ProgressionGame() {
        engine = new Engine(this::generateQuestion, this::calculateAnswer);
    }

    public String getName() {
        return "Progression";
    };

    public void play() {
        System.out.println("What number is missing in the progression?");

        engine.run();
    }
    private String generateQuestion() {
        int length = randomizer.nextInt(minLength, maxLength);
        int step = randomizer.nextInt(minStep, maxStep);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(randomizer.nextInt(maxRandomNumber));
        for (int i = 0; i < length; i++) {
            numbers.add(numbers.get(i) + step);
        }

        numbers.set(randomizer.nextInt(length), null);

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

    private String calculateAnswer(String question) {
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

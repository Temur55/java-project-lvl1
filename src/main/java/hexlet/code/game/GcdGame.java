package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class GcdGame implements Game {
    private final Random randomizer = new Random();
    private final Integer maxRandomNumber = 100;
    private final Integer minRandomNumber = 2;
    private final Engine engine;

    public GcdGame() {
        engine = new Engine(this::generateQuestion, this::calculateAnswer);
    }

    public String getName() {
        return "GCD";
    };

    public void play() {
        System.out.println("Find the greatest common divisor of given numbers.");

        engine.run();
    }
    private String generateQuestion() {
        return "%s %s".formatted(String.valueOf(randomizer.nextInt(minRandomNumber, maxRandomNumber)),
                String.valueOf(randomizer.nextInt(minRandomNumber, maxRandomNumber)));
    }

    private String calculateAnswer(String question) {
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

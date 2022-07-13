package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class PrimeGame implements Game {
    private final Random randomizer = new Random();
    private final Integer maxRandomNumber = 100;
    private final Integer minRandomNumber = 2;
    private final Engine engine;

    public PrimeGame() {
        engine = new Engine(this::generateQuestion, this::calculateAnswer);
    }

    public String getName() {
        return "Prime";
    };

    public void play() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        engine.run();
    }
    private String generateQuestion() {
        return String.valueOf(randomizer.nextInt(minRandomNumber, maxRandomNumber));
    }

    private String calculateAnswer(String question) {
        int number = Integer.parseInt(question);

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }
}

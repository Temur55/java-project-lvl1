package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class EvenGame implements Game {
    private final Random randomizer = new Random();
    private final Integer maxRandomNumber = 100;
    private final Engine engine;

    public EvenGame() {
        engine = new Engine(this::generateQuestion, q -> checkNumberIsEven(Integer.parseInt(q)) ? "yes" : "no");
    }

    public String getName() {
        return "Even";
    };

    public void play() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        engine.run();
    }

    private boolean checkNumberIsEven(int number) {
        return (number % 2 == 0);
    }

    private String generateQuestion() {
        return String.valueOf(randomizer.nextInt(maxRandomNumber));
    }

}

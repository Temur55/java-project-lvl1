package hexlet.code.game;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class CalculatorGame implements Game {
    private final Random randomizer = new Random();

    private final Integer maxRandomNumber = 100;

    private final List<String> operationList = new ArrayList<>();
    private final Engine engine;

    public CalculatorGame() {
        engine = new Engine(this::generateQuestion, this::calculateAnswer);
        operationList.add("+");
        operationList.add("-");
        operationList.add("*");
    }

    public String getName() {
        return "Calc";
    };

    public void play() {
        System.out.println("What is the result of the expression?");

        engine.run();
    }

    private String generateQuestion() {
        return "%s %s %s".formatted(String.valueOf(randomizer.nextInt(maxRandomNumber)),
                getRandomOperation(), String.valueOf(randomizer.nextInt(maxRandomNumber)));
    }

    private String getRandomOperation() {
        return operationList.get(randomizer.nextInt(operationList.size()));
    }

    private String calculateAnswer(String question) {
        String[] operands = question.split(" ");
        int left = Integer.parseInt(operands[0]);
        int right = Integer.parseInt(operands[2]);
        return switch (operands[1]) {
            case "+" -> String.valueOf(left + right);
            case "-" -> String.valueOf(left - right);
            case "*" -> String.valueOf(left * right);
            default -> "";
        };
    }
}

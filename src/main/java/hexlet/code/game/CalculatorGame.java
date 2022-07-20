package hexlet.code.game;

import hexlet.code.Engine;

import java.util.Random;

public final class CalculatorGame {
    private static final Random RANDOMIZER = new Random();

    private static final Integer MAX_RANDOM_NUMBER = 100;

    private static final int OPERATIONS_COUNT = 3;

    private static final String[] OPERATIONS = new String[OPERATIONS_COUNT];


    static {
        OPERATIONS[0] = "+";
        OPERATIONS[1] = "-";
        OPERATIONS[2] = "*";
    }

    public static String getName() {
        return "Calc";
    };

    public static void play() {
        Engine.callIntro("What is the result of the expression?");

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
        return "%s %s %s".formatted(String.valueOf(RANDOMIZER.nextInt(MAX_RANDOM_NUMBER)),
                getRandomOperation(), String.valueOf(RANDOMIZER.nextInt(MAX_RANDOM_NUMBER)));
    }

    private static String getRandomOperation() {
        return OPERATIONS[RANDOMIZER.nextInt(OPERATIONS.length)];
    }

    private static String calculateAnswer(String question) {
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

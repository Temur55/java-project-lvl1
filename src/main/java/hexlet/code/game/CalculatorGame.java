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
        String[][] questionAnswerPair = new String[Engine.getCountOfCheck()][2];
        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            questionAnswerPair[i] = generateQuestionAnswerPair();
        }
        Engine.run("What is the result of the expression?", questionAnswerPair);
    }


    private static String[] generateQuestionAnswerPair() {
        int leftNumber = RANDOMIZER.nextInt(MAX_RANDOM_NUMBER);
        int rightNumber = RANDOMIZER.nextInt(MAX_RANDOM_NUMBER);
        String operation = getRandomOperation();
        String question = "%s %s %s".formatted(leftNumber, operation, rightNumber);
        String answer = calculateAnswer(leftNumber, rightNumber, operation);

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = question;
        questionAnswerPair[1] = answer;
        return questionAnswerPair;
    }

    private static String getRandomOperation() {
        return OPERATIONS[RANDOMIZER.nextInt(OPERATIONS.length)];
    }

    private static String calculateAnswer(int leftNumber, int rightNumber, String operation) {
        return switch (operation) {
            case "+" -> String.valueOf(leftNumber + rightNumber);
            case "-" -> String.valueOf(leftNumber - rightNumber);
            case "*" -> String.valueOf(leftNumber * rightNumber);
            default -> "";
        };
    }
}

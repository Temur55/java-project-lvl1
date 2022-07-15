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
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String question;

        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            question = generateQuestion();
            Engine.setQuestionAnswerPair(question, calculateAnswer(question));
        }
        Engine.run();
    }

    private static boolean checkNumberIsEven(int number) {
        return (number % 2 == 0);
    }

    private static String generateQuestion() {
        return String.valueOf(RANDOMIZER.nextInt(MAX_RANDOM_NUMBER));
    }

    private static String calculateAnswer(String question) {
        return checkNumberIsEven(Integer.parseInt(question)) ? "yes" : "no";
    }

}

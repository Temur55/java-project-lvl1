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
        Engine.callIntro("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String question;
        String[][] questionAnswerPair = new String[Engine.getCountOfCheck()][2];
        for (int i = 0; i < Engine.getCountOfCheck(); i++) {
            question = generateQuestion();
            questionAnswerPair[i][0] = question;
            questionAnswerPair[i][1] = calculateAnswer(question);
        }
        Engine.run(questionAnswerPair);
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

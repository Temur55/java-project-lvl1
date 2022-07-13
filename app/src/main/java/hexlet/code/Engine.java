package hexlet.code;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Engine {
    private final int countOfCheck = 3;
    private final Scanner scanner = new Scanner(System.in);

    private final Supplier<String> questionGenerator;
    private final Function<String, String> answerGenerator;

    public Engine(Supplier<String> questionGeneratorInit, Function<String, String> answerGeneratorInit) {
        this.questionGenerator = questionGeneratorInit;
        this.answerGenerator = answerGeneratorInit;
    }

    public void run() {
        int rightAnswers;

        for (rightAnswers = 0; rightAnswers < countOfCheck; rightAnswers++) {
            String question = questionGenerator.get();
            System.out.printf("Question: %s\n", question);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            String rightAnswer = answerGenerator.apply(question);
            if (rightAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, rightAnswer);
                System.out.printf("Let's try again, %s!\n", Player.getName());
                break;
            }
        }

        if (rightAnswers < countOfCheck) {
            return;
        }

        System.out.printf("Congratulations, %s!", Player.getName());
    }
}

package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void welcome() {

        Scanner cliScanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");

        System.out.print("May I have your name? ");

        String name = cliScanner.nextLine();

        System.out.printf("Hello, %s!\n", name);
    }
}

package hexlet.code;

import hexlet.code.game.CalculatorGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.GcdGame;
import hexlet.code.game.PrimeGame;
import hexlet.code.game.ProgressionGame;

import java.util.Scanner;

public final class GameFactory {
    private static String gameNumber = null;

    private static final int GAME_COUNT = 6;

    private static final int GREET_ORDER = 0;

    private static final int EVEN_GAME_ORDER = 1;

    private static final int CALC_GAME_ORDER = 2;

    private static final int GCD_GAME_ORDER = 3;

    private static final int PROG_GAME_ORDER = 4;

    private static final int PRIME_GAME_ORDER = 5;

    public static void selectGame() {
        Scanner scanner = new Scanner(System.in);
        String[] games = getGames();

        for (int i = 0; i < games.length; i++) {
            System.out.printf("%s - %s\n", i, games[i]);
        }

        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        gameNumber = scanner.nextLine();
    }

    public static void play() {
        if (gameNumber == null) {
            return;
        }
        switch (gameNumber) {
            case "1" -> Cli.welcome();
            case "2" -> EvenGame.play();
            case "3" -> CalculatorGame.play();
            case "4" -> GcdGame.play();
            case "5" -> ProgressionGame.play();
            case "6" -> PrimeGame.play();
            default -> { }
        }
    }
    private static String[] getGames() {
        String[] gameMap = new String[GAME_COUNT];

        gameMap[GREET_ORDER] = "Greet";
        gameMap[EVEN_GAME_ORDER] = EvenGame.getName();
        gameMap[CALC_GAME_ORDER] = CalculatorGame.getName();
        gameMap[GCD_GAME_ORDER] = GcdGame.getName();
        gameMap[PROG_GAME_ORDER] = ProgressionGame.getName();
        gameMap[PRIME_GAME_ORDER] = PrimeGame.getName();

        return gameMap;
    }
}

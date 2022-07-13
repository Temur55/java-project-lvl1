package hexlet.code;

import hexlet.code.game.CalculatorGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.Game;
import hexlet.code.game.GcdGame;
import hexlet.code.game.PrimeGame;
import hexlet.code.game.ProgressionGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class GameFactory {
    private Game game = null;

    public void selectGame() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Game> gameMap = getGameMap();
        System.out.println("1 - Greet");

        for (Map.Entry<String, Game> entry : gameMap.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue().getName());
        }

        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        String selectedGame = scanner.nextLine();

        if ("1".equals(selectedGame)) {
            Cli.welcome();
        }

        this.game = gameMap.getOrDefault(selectedGame, null);
    }

    public void play() {
        if (game == null) {
            return;
        }
        game.play();
    }
    private Map<String, Game> getGameMap() {
        Map<String, Game> gameMap = new HashMap<>();

        gameMap.put("2", new EvenGame());
        gameMap.put("3", new CalculatorGame());
        gameMap.put("4", new GcdGame());
        gameMap.put("5", new ProgressionGame());
        gameMap.put("6", new PrimeGame());

        return gameMap;
    }
}

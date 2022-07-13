package hexlet.code;

public class App {
    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory();

        System.out.println("Welcome to the Brain Games!");
        Cli.welcome();

        gameFactory.selectGame();
        gameFactory.play();
    }

}

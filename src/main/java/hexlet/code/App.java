package hexlet.code;

public class App {
    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory();

        gameFactory.selectGame();
        gameFactory.play();
    }

}

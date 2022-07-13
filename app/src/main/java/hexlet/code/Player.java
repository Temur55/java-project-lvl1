package hexlet.code;

public class Player {
    private static String name;

    public static void setName(String newName) {
        Player.name = newName;
    }

    public static String getName() {
        return Player.name;
    }
}

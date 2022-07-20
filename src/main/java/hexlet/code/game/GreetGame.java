package hexlet.code.game;

import hexlet.code.Engine;

public class GreetGame {
    public static String getName() {
        return "Greet";
    };

    public static void play() {
        Engine.callIntro(null);
    }
}

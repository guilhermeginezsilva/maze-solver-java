package app;

import app.model.Actor;
import app.model.Scenery;
import app.model.World;

public class Launcher {

    private static StringBuffer textMap = new StringBuffer(
            "XXXXXXXXXXXXXXXXXXXX\n"+
            "XS     X           X\n"+
            "XX XXX XX XXXX XXX X\n"+
            "X  XXX    XXXX XXX X\n"+
            "X XX XX XX XXX XXX X\n"+
            "X    XXXXX     XXX X\n"+
            "XXXXXXXXXXXXXXXXXXEX"
    );

    public static void main(String[] args) {

        System.out.println(textMap+"\n");

        Scenery scenery = MapLoader.textToMap(textMap, 20, 7);
        Actor actor = new Actor(20, 7 , scenery.startPosition);

        World mazeWorld = new World(scenery, actor);
        mazeWorld.runWorld();
    }



}

package app.model;

public class World {

    public static Actor actor;
    public static Scenery scenery;

    public World(Scenery scenery, Actor actor) {
        this.scenery = scenery;
        this.actor = actor;
    }

    public void runWorld() {

        while(true) {
            int ret = actor.act();

            for(int i=0; i< scenery.map[0].length; i++) {
                for(int j=0; j< scenery.map.length; j++) {
                    if(actor.position.x == j && actor.position.y ==i) {
                        System.out.print("0");
                    } else {
                        System.out.print(scenery.map[j][i]);
                    }
                }
                System.out.print("\n");
            }

            switch (ret) {
                case -1:
                    System.out.println("There is no exit");
                    return;
                case 0:
                    continue;
                case 1:
                    System.out.println("Exited the maze");
                    return;
            }
        }
    }



}

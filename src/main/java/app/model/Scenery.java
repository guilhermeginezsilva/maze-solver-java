package app.model;

import java.util.ArrayList;
import java.util.List;

public class Scenery {

    public char[][] map;
    public Coord2D startPosition;
    public Coord2D endPosition;

    public Coord2D hasEndAround(Coord2D coord) {

        //Left
        Coord2D leftCoord = new Coord2D(coord.xMinus(1), coord.y);
        if(endPosition.equals(leftCoord)) return leftCoord;

        //Up
        Coord2D upCoord = new Coord2D(coord.x, coord.yPlus(1));
        if(endPosition.equals(upCoord)) return upCoord;

        //Right
        Coord2D rightCoord = new Coord2D(coord.xPlus(1), coord.y);
        if(endPosition.equals(rightCoord)) return rightCoord;

        //Down
        Coord2D downCoord = new Coord2D(coord.x, coord.yMinus(1));
        if(endPosition.equals(downCoord)) return downCoord;

        return null;
    }

    public boolean isBlock(Coord2D coord) {
        if(coord.x < 0 || coord.x >= map.length || coord.y < 0 || coord.y >= map[0].length) {
            return true;
        }

        switch (map[coord.x][coord.y]) {
            case 'X':
                return true;
            default:
                return false;
        }
    }

    public boolean isPath(Coord2D coord) {
        if(coord.x < 0 || coord.x >= map.length || coord.y < 0 || coord.y >= map[0].length) {
            return false;
        }

        switch (map[coord.x][coord.y]) {
            case ' ':
                return true;
            default:
                return false;
        }
    }

    public List<Coord2D> hasPathAround(Coord2D coord) {
        List<Coord2D> paths = new ArrayList<Coord2D>();

        //Left
        Coord2D leftCoord = new Coord2D(coord.xMinus(1), coord.y);
        if(isPath(leftCoord)) paths.add(leftCoord);

        //Up
        Coord2D upCoord = new Coord2D(coord.x, coord.yPlus(1));
        if(isPath(upCoord)) paths.add(upCoord);

        //Right
        Coord2D rightCoord = new Coord2D(coord.xPlus(1), coord.y);
        if(isPath(rightCoord)) paths.add(rightCoord);

        //Down
        Coord2D downCoord = new Coord2D(coord.x, coord.yMinus(1));
        if(isPath(downCoord)) paths.add(downCoord);

        return paths;
    }

    public List<Coord2D> hasPathAround(Coord2D coord, Coord2D oldCoord) {
        List<Coord2D> paths = new ArrayList<Coord2D>();

        //Left
        Coord2D leftCoord = new Coord2D(coord.xMinus(1), coord.y);
        if(!oldCoord.equals(leftCoord)) {
            if (isPath(leftCoord)) paths.add(leftCoord);
        }

        //Up
        Coord2D upCoord = new Coord2D(coord.x, coord.yPlus(1));
        if(!oldCoord.equals(upCoord)) {
            if (isPath(upCoord)) paths.add(upCoord);
        }

        //Right
        Coord2D rightCoord = new Coord2D(coord.xPlus(1), coord.y);
        if(!oldCoord.equals(rightCoord)) {
            if (isPath(rightCoord)) paths.add(rightCoord);
        }

        //Down
        Coord2D downCoord = new Coord2D(coord.x, coord.yMinus(1));
        if(!oldCoord.equals(downCoord)) {
            if (isPath(downCoord)) paths.add(downCoord);
        }

        return paths;
    }

}

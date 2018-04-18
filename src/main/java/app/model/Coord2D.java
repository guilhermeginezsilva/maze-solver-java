package app.model;

public class Coord2D {
    public int x;
    public int y;

    public Coord2D(int x, int y) {
        this.x =x;
        this.y =y;
    }

    public int xPlus(int value) {
        return x+value;
    }
    public int xMinus(int value) {
        return x-value;
    }
    public int yPlus(int value) {
        return y+value;
    }
    public int yMinus(int value) {
        return y-value;
    }

    public boolean equals(Coord2D coord2D) {
        return (this.x == coord2D.x && this.y == coord2D.y)? true : false;
    }
}

package entity.tile;

public class Point {
    private int posX;
    private int posY;

    public Point (int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public Point(Point other) {
        this.posX = other.getPosX();
        this.posY = other.getPosY();
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return this.posY;
    }

    public boolean equals(Point other) {
        if (this.posX == other.getPosX()) {
            if (this.posY == other.getPosY()) return true;
        }
        return false;
    }
    public void set(java.awt.Point other) {
        posX = other.x;
        posY = other. y;
    }
}

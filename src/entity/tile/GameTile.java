package entity.tile;

import entity.GameEntity;

import java.awt.*;

public abstract class GameTile extends GameEntity {
    private Point point;

    public GameTile(int posX, int posY){
        point = new Point(posX, posY);
    }
    public GameTile(Point point) {
        this.point = new Point(point.getPosX(), point.getPosY());
    }

    public Point getPoint() {
        return this.point;
    }
    public int getPosX() {
        return point.getPosX();
    }
    public void setPosX(int posX) {
        point.setPosX(posX);
    }
    public int getPosY() {
        return point.getPosY();
    }
    public void setPosY(int posY) {
        point.setPosY(posY);
    }
    public abstract void update();
}

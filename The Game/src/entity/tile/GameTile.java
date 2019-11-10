package entity.tile;

import entity.GameEntity;

import java.awt.*;

public abstract class GameTile implements GameEntity {
    private int posX;
    private int posY;

    public GameTile(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return this.posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int getPosY() {
        return this.posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public abstract void update();
    public abstract void draw(Graphics2D g);
}

package entity.tile.tower;

import entity.tile.GameTile;

import java.awt.*;

public class AbstractTower extends GameTile {
    private int speed;
    private double range;
    public AbstractTower(int posX, int posY, double range, int speed) {
        super(posX, posY);
        this.range = range;
        this.speed = speed;
        doDraw();
    }
    private void doDraw() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {

    }
}

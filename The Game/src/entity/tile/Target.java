package entity.tile;


import drawer.Road.drawTarget;

import java.awt.*;

public class Target extends GameTile {
    public Target(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void update() {

    }
    @Override
    public void draw(Graphics2D g) {
        drawTarget.draw(super.getPosX(), super.getPosY(), g);
    }
}

package entity.tile;

import drawer.Road.drawSpawner;

import java.awt.*;

public class Spawner extends GameTile {
    public Spawner(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void update() {

    }
    @Override
    public void draw(Graphics2D g) {
        drawSpawner.draw(super.getPosX(), super.getPosY(), g);
    }
}

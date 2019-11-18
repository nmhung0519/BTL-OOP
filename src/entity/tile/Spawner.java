package entity.tile;

import drawer.Road.drawSpawner;

import java.awt.*;

public class Spawner extends Road {
    public Spawner(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void update() {

    }
    @Override
    public void doDrawing(Graphics g) {
        drawSpawner.draw(super.getPosX() - 50, super.getPosY() - 50, g);
    }
}

package entity.tile;


import drawer.Road.drawTarget;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Target extends Road {
    public Target(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void update() {

    }
    @Override
    public void doDrawing(Graphics g) {
        drawTarget.draw(super.getPosX(), super.getPosY(), g);
    }
}

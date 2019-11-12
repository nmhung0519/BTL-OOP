package entity.tile;

import drawer.Road.drawRoad;

import java.awt.*;

public class Road extends GameTile {
    private double distance;

    public Road(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void update() {
    }

    public double getDistance() {
        return this.distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    @Override
    public void doDrawing(Graphics g) {
        drawRoad.draw(super.getPosX(), super.getPosY(), g);
    }
}

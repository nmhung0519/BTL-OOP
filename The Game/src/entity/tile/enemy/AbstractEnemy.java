package entity.tile.enemy;

import entity.tile.GameTile;
import entity.tile.Road;
import entity.tile.Point;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public abstract class AbstractEnemy extends GameTile {
    private int health;
    private int armor;
    private int speed;
    private int reward;
    private boolean alive;
    private Point nextPoint;

    public AbstractEnemy(Point point, Point nextPoint, int health, int armor, int speed, int reward) {
        super(point.getPosX(), point.getPosY());
        this.nextPoint = nextPoint;
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.alive = true;
    }

    public Point getNextPoint() {
        return this.nextPoint;
    }

    public void setNextPoint(Point p) {
        this.nextPoint = p;
    }

    @Override
    public void update() {
        if (super.getPosX() < nextPoint.getPosX()) {
            super.setPosX(super.getPosX() + speed);
        }
        if (super.getPosX() > nextPoint.getPosX()) {
            super.setPosX(super.getPosX() - speed);
        }
        if (super.getPosY() < nextPoint.getPosY()) {
            super.setPosY(super.getPosY() + speed);
        }
        if (super.getPosY() > nextPoint.getPosY()) {
            super.setPosY(super.getPosY() - speed);
        }
    }
    public abstract void doDrawing(Graphics g) ;
    public boolean getAlive() {
        return this.alive;
    }
    public int getReward() {
        return this.reward;
    }
}

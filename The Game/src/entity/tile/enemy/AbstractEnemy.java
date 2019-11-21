package entity.tile.enemy;

import entity.tile.GameTile;
import entity.tile.Road;
import entity.tile.Point;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import drawer.drawEnemy;


public abstract class AbstractEnemy extends GameTile {
    private int health;
    private int armor;
    private int speed;
    private int reward;
    private boolean alive;
    private Point nextPoint;
    private int distance;
    private int maxHealth;
    private Image img;

    public AbstractEnemy(String imgPath, Point point, Point nextPoint, int health, int armor, int speed, int reward) {
        super(point.getPosX(), point.getPosY());
        this.nextPoint = nextPoint;
        this.health = health;
        this.maxHealth = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.alive = true;
        this.distance = 0;
        img = new ImageIcon(imgPath).getImage();

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
        distance += speed;
    }
    public void doDrawing(Graphics g) {
        update();
        drawEnemy.draw(img, this, g);
    }
    public boolean getAlive() {
        return this.alive;
    }
    public int getReward() {
        return this.reward;
    }
    public boolean outDistance() {
        return false;
    }
    public void degreeHP(int n) {
        System.out.println(n - armor);
        health -= (n - armor);
    }
    public boolean life() {
        if (health > 0) return true;
        else return false;
    }
    public int getMaxHealth() {
        return this.maxHealth;
    }
    public int getHealth() {
        return this.health;
    }
    public int getDistance() {
        return this.distance;
    }
}

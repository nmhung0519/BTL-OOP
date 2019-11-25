package entity.tile;

import entity.tile.GameTile;
import entity.tile.Road;
import entity.tile.Point;

import Config.Config;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import drawer.drawEnemy;


public class Enemy extends GameTile {
    private int type;
    private int health;
    private int armor;
    private int speed;
    private int reward;
    private boolean alive;
    private Point nextPoint;
    private int distance;
    private int maxHealth;
    private Image img;

    public Enemy(int type, Image img, Point point, Point nextPoint) {
        super(point.getPosX(), point.getPosY());
        this.type = type;
        this.nextPoint = nextPoint;
        if (type == 1) {
            this.health = Config.NORMAL_ENEMY_HEALTH;
            this.armor = Config.NORMAL_ENEMY_ARMOR;
            this.speed = Config.NORMAL_ENEMY_SPEED;
            this.reward = Config.NORMAL_ENEMY_REWARD;
        }
        else if (type == 2) {
            this.health = Config.SMALLER_ENEMY_HEALTH;
            this.armor = Config.SMALLER_ENEMY_ARMOR;
            this.speed = Config.SMALLER_ENEMY_SPEED;
            this.reward = Config.SMALLER_ENEMY_REWARD;
        }
        else if (type == 3) {
            this.health = Config.TANKER_ENEMY_HEALTH;
            this.armor = Config.TANKER_ENEMY_ARMOR;
            this.speed = Config.TANKER_ENEMY_SPEED;
            this.reward = Config.TANKER_ENEMY_REWARD;
        }
        else if (type == 4) {
            this.health = Config.BOSS_ENEMY_HEALTH;
            this.armor = Config.BOSS_ENEMY_ARMOR;
            this.speed = Config.BOSS_ENEMY_SPEED;
            this.reward = Config.BOSS_ENEMY_REWARD;
        }
        maxHealth = health;
        this.alive = true;
        this.distance = 0;
        this.img = img;

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

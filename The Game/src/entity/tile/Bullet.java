package entity.tile;

import drawer.drawBullet;
import entity.tile.Enemy;
import entity.tile.GameTile;
import entity.tile.Point;
import Config.Config;

import javax.swing.*;
import java.awt.*;

public class Bullet extends GameTile {
    private Enemy enemy;
    private int strength;
    private double speed;
    private int count;
    private int TTL;
    private Image img;

    public Bullet(int type, Image img, Point point, Enemy enemy) {
        super(point);
        this.img = img;
        this.enemy = enemy;
        if (type == 1) {
            this.speed = Config.NORMAL_BULLET_SPEED;
            this.strength = Config.NORMAL_BULLET_STRENGTH;
            this.TTL = Config.NORMAL_BULLET_TTL;
        }
        else if (type == 2) {
            this.speed = Config.MACHINE_GUN_BULLET_SPEED;
            this.strength = Config.MACHINE_GUN_BULLET_STRENGTH;
            this.TTL = Config.MACHINE_GUN_BULLET_TTL;
        }
        else if (type == 3) {
            this.speed = Config.SNIPER_BULLET_SPEED;
            this.strength = Config.SNIPER_BULLET_STRENGTH;
            this.TTL = Config.SNIPER_BULLET_TTL;
        }
    }
    public void update() {
        int deltaX = enemy.getPosX() - getPosX();
        int deltaY = enemy.getPosY() - getPosY();
        double delta  = Math.sqrt((double)(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
        if (delta <= speed) {
            setPosX(enemy.getPosX());
            setPosY(enemy.getPosY());
            TTL = 0;
        }
        else {
            setPosX(getPosX() + (int) (speed * (deltaX / delta)));
            setPosY(getPosY() + (int) (speed * (deltaY / delta)));
        }
    }
    public void Catch() {
        if (getPoint().equals(enemy.getPoint())) {
            enemy.degreeHP(strength);
        }
    }
    public boolean life () {
        TTL--;
        if (TTL <= 0) return false;
        else return true;
    }
    public Enemy getEnemy() {
        return this.enemy;
    }
    public Image getImg() {
        return this.img;
    }
    public void doDrawing(Graphics g) {
        update();
        System.out.println(getPosX() + " - " + getPosY());
        drawBullet.draw(this, g);
    }
}

package entity.tile.Bullet;

import entity.GameEntity;
import entity.tile.GameTile;
import entity.tile.Point;
import entity.tile.enemy.AbstractEnemy;

import javax.swing.*;
import java.awt.*;
import drawer.drawBullet;

public abstract class AbstractBullet extends GameTile {
    private AbstractEnemy enemy;
    private int strength;
    private double speed;
    private int count;
    private int TTL;
    private Image img;

    public AbstractBullet(String path, Point point, AbstractEnemy enemy, int strength, double speed, int TTL) {
        super(point);
        img = new ImageIcon(path).getImage();
        this.enemy = enemy;
        this.count = 0;
        this.speed = speed;
        this.strength = strength;
        this.TTL = TTL;
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
    public AbstractEnemy getEnemy() {
        return this.enemy;
    }
    public Image getImg() {
        return this.img;
    }
    public void doDrawing(Graphics g) {
        drawBullet.draw(this, g);
    }
}

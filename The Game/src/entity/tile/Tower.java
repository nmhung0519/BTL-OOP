package entity.tile;

import entity.tile.Bullet.AbstractBullet;
import entity.tile.Bullet.NormalBullet;
import entity.tile.GameTile;
import entity.tile.Point;
import entity.tile.enemy.AbstractEnemy;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import drawer.drawTower;

public class Tower extends GameTile {
    private int speed;
    private double range;
    private int count;
    private AbstractEnemy target;
    protected Image tower, gun;
    public Tower(Image tower, Image gun, int posX, int posY, double range, int speed) {
        super(posX, posY);
        target = null;
        this.range = range;
        this.speed = speed;
        count = 1;
        this.tower = tower;
        this.gun = gun;
    }
    @Override
    public void update() {
    }
    @Override
    public void doDrawing(Graphics g) {
        update();
        drawTower.draw(tower, gun, getPoint(), target, g);
    }
    public boolean inDistance(Point point) {
        double distance = Math.sqrt((double) (Math.pow(this.getPosX() - point.getPosX(), 2) + Math.pow(this.getPosY() - point.getPosY(), 2)));
        if (distance <= range) return true;
        else return false;
    }
    public AbstractEnemy targetEnemy(List<AbstractEnemy> enemies) {
        AbstractEnemy result = null;
        for (AbstractEnemy enemy : enemies) {
            if (inDistance(enemy.getPoint())) {
                if (result == null) result = enemy;
                else {
                    if (result.getDistance() < enemy.getDistance()) result = enemy;
                }
            }
        }
        target = result;
        return result;
    }
    public double getRange() {
        return this.range;
    }
    public AbstractBullet spawnBullet(AbstractEnemy enemy) {
        return new NormalBullet(getPoint(), enemy);
    }
    public boolean canShoot() {
        count--;
        if (count == 0) {
            count = speed;
            return true;
        }
        return false;
    }
    public Image getGun() {
        return this.gun;
    }
    public Image getImage() {
        return tower;
    }
    public AbstractEnemy getTarget() {
        return target;
    }
}

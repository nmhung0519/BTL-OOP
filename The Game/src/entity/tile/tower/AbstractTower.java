package entity.tile.tower;

import entity.tile.Bullet.AbstractBullet;
import entity.tile.GameTile;
import entity.tile.Point;
import entity.tile.enemy.AbstractEnemy;

import java.awt.*;
import java.util.List;

public abstract class AbstractTower extends GameTile {
    private int speed;
    private double range;
    private int count;
    public AbstractTower(int posX, int posY, double range, int speed) {
        super(posX, posY);
        this.range = range;
        this.speed = speed;
        count = 1;
    }
    @Override
    public void update() {
        this.setPosX(getPosX() + 10);
    }
    @Override
    public abstract void doDrawing(Graphics g);
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
        return result;
    }
    public double getRange() {
        return this.range;
    }
    public abstract AbstractBullet spawnBullet(AbstractEnemy enemy);
    public boolean canShoot() {
        count--;
        if (count == 0) {
            count = speed;
            return true;
        }
        return false;
    }
}

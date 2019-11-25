package entity.tile;

import java.awt.*;
import java.util.List;
import drawer.drawTower;

public class Tower extends GameTile {
    private int type;
    private int speed;
    private double range;
    private int count;
    private Enemy target;
    protected Image tower, gun;
    public Tower(int type, Image tower, Image gun, int posX, int posY, double range, int speed) {
        super(posX, posY);
        this.type = type;
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
    public Enemy targetEnemy(List<Enemy> enemies) {
        Enemy result = null;
        for (Enemy enemy : enemies) {
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
    public Enemy getTarget() {
        return target;
    }
    public int getType() {
        return type;
    }
}

package entity.tile.Bullet;

import entity.GameEntity;
import entity.tile.GameTile;
import entity.tile.Point;
import entity.tile.enemy.AbstractEnemy;
import entity.tile.tower.AbstractTower;

public abstract class AbstractBullet extends GameTile {
    private AbstractEnemy enemy;
    private int strength;
    private double speed;
    private int count;
    private int TTL;

    public AbstractBullet(Point point, AbstractEnemy enemy, int strength, double speed, int TTL) {
        super(point);
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
}

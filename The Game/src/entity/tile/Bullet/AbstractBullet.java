package entity.tile.Bullet;

import entity.GameEntity;

public abstract class AbstractBullet implements GameEntity {
    private double posX;
    private double posY;
    private int strength;
    private double speed;

    public AbstractBullet(int posX, int posY, int strength, double speed) {
        this.posX = (double) posX;
        this.posY = (double) posY;
        this.strength = strength;
        this.speed = speed;
    }
}

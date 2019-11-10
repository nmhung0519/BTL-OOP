package entity.tile.enemy;

import entity.tile.GameTile;

import java.awt.*;


public abstract class AbstractEnemy extends GameTile {
    private int health;
    private int armor;
    private double speed;
    private int reward;


    public AbstractEnemy(int posX, int posY, int health, int armor, double speed, int reward) {
        super(posX, posY);
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
    }

    @Override
    public void update() {
        
    }
    public void Spawn() {
    }
    @Override
    public void draw(Graphics2D g) {

    }
}

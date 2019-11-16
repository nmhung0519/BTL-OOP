package entity.tile.tower;
import Config.Config;
import entity.tile.Bullet.AbstractBullet;
import entity.tile.Bullet.SniperBullet;
import entity.tile.enemy.AbstractEnemy;
import drawer.Tower.*;
import java.awt.*;

public class SniperTower extends AbstractTower {

    public SniperTower(int posX, int posY) {
        super(posX, posY, Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED);
    }
    public SniperBullet spawnBullet(AbstractEnemy enemy) {
        return new SniperBullet(getPoint(), enemy);
    }

    @Override
    public void doDrawing(Graphics g) {
        drawSniperTower.draw(this.getPoint(), g);
    }
}

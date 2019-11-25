package entity.tile.tower;
import Config.Config;
import entity.tile.Bullet.AbstractBullet;
import entity.tile.Bullet.NormalBullet;
import entity.tile.enemy.AbstractEnemy;
import drawer.Tower.*;

import java.awt.*;

public class NormalTower extends AbstractTower {

    public NormalTower(int posX, int posY) {
        super(posX, posY, Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_SPEED);
    }

    @Override
    public void doDrawing(Graphics g) {
        drawNormalTower.draw(this.getPoint(), super.getTarget(), (Graphics2D) g);
    }

    public AbstractBullet spawnBullet(AbstractEnemy enemy) {
        return new NormalBullet(getPoint(), enemy);
    }
}

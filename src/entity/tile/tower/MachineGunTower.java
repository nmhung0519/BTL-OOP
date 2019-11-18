package entity.tile.tower;
import Config.Config;
import entity.tile.Bullet.AbstractBullet;
import entity.tile.Bullet.MachineGunBullet;
import entity.tile.enemy.AbstractEnemy;
import drawer.Tower.*;

import java.awt.*;

public class MachineGunTower extends AbstractTower {

    public MachineGunTower(int posX, int posY) {
        super(posX, posY, Config.MACHINEGUN_TOWER_RANGE, Config.MACHINEGUN_TOWER_SPEED);
    }
    public void doDrawing(Graphics g) {
        drawMachineGunTower.draw(getPoint(), g);
    }
    public AbstractBullet spawnBullet(AbstractEnemy enemy) {
        return new MachineGunBullet(getPoint(), enemy);
    }
}

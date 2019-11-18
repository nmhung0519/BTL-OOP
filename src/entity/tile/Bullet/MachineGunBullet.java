package entity.tile.Bullet;

import Config.Config;
import entity.tile.enemy.AbstractEnemy;
import entity.tile.tower.AbstractTower;
import entity.tile.Point;
import java.awt.*;
import drawer.Bullet.*;
import entity.tile.tower.MachineGunTower;

public class MachineGunBullet extends AbstractBullet {
    public MachineGunBullet(Point point, AbstractEnemy enemy) {
        super(point, enemy, Config.MACHINE_GUN_BULLET_STRENGTH, Config.MACHINE_GUN_BULLET_SPEED, Config.MACHINE_GUN_BULLET_TTL);
    }

    @Override
    public void doDrawing(Graphics g) {
        super.update();
        drawMachineGunBullet.draw(getPosX(), getPosY(), g);
    }
}

package entity.tile.Bullet;

import Config.Config;
import drawer.drawBullet;
import entity.tile.enemy.AbstractEnemy;
import entity.tile.Point;
import java.awt.*;

public class MachineGunBullet extends AbstractBullet {
    public MachineGunBullet(Point point, AbstractEnemy enemy) {
        super("out/production/Picture/Bullet/MachineGunBullet.png", point, enemy, Config.MACHINE_GUN_BULLET_STRENGTH, Config.MACHINE_GUN_BULLET_SPEED, Config.MACHINE_GUN_BULLET_TTL);
    }

    @Override
    public void doDrawing(Graphics g) {
        super.update();
        drawBullet.draw(this, g);
    }
}

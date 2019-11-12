package entity.tile.Bullet;

import Config.Config;

import java.awt.*;

public class MachineGunBullet extends AbstractBullet {
    public MachineGunBullet(int posX, int posY) {
        super(posX, posY, Config.MACHINE_GUN_BULLET_STRENGTH, Config.MACHINE_GUN_BULLET_SPEED);
    }

    @Override
    public void doDrawing(Graphics g) {

    }
}

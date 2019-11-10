package entity.tile.Bullet;

import Config.Config;

public class MachineGunBullet extends AbstractBullet {
    public MachineGunBullet(int posX, int posY) {
        super(posX, posY, Config.MACHINE_GUN_BULLET_STRENGTH, Config.MACHINE_GUN_BULLET_SPEED);
    }
}

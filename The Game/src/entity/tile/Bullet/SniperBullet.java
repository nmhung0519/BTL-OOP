package entity.tile.Bullet;

import Config.Config;

public class SniperBullet extends AbstractBullet {
    public SniperBullet(int posX, int posY) {
        super(posX, posY, Config.SNIPER_BULLET_STRENGTH, Config.SNIPER_BULLET_SPEED);
    }
}

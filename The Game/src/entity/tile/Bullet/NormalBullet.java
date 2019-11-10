package entity.tile.Bullet;

import Config.Config;

public class NormalBullet extends AbstractBullet {

    public NormalBullet(int posX, int posY) {
        super(posX, posY, Config.NORMAL_BULLET_STRENGTH, Config.NORMAL_BULLET_SPEED);
    }
}

package entity.tile.Bullet;

import Config.Config;

import java.awt.*;

public class SniperBullet extends AbstractBullet {
    public SniperBullet(int posX, int posY) {
        super(posX, posY, Config.SNIPER_BULLET_STRENGTH, Config.SNIPER_BULLET_SPEED);
    }

    @Override
    public void doDrawing(Graphics g) {

    }
}

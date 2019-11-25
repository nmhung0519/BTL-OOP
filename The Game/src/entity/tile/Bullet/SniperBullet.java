package entity.tile.Bullet;

import Config.Config;
import java.awt.*;
import entity.tile.Point;
import entity.tile.enemy.AbstractEnemy;
import drawer.drawBullet;

public class SniperBullet extends AbstractBullet {
    public SniperBullet(Point point, AbstractEnemy enemy) {
        super("out/production/Picture/Bullet/SniperBullet.png", point, enemy, Config.SNIPER_BULLET_STRENGTH, Config.SNIPER_BULLET_SPEED, Config.SNIPER_BULLET_TTL);
    }

    @Override
    public void doDrawing(Graphics g) {
        super.update();
        drawBullet.draw(this, g);
    }
}

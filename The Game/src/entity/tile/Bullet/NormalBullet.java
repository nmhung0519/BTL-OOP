package entity.tile.Bullet;

import Config.Config;

import java.awt.*;
import entity.tile.Point;
import entity.tile.enemy.AbstractEnemy;
import drawer.drawBullet;

public class NormalBullet extends AbstractBullet {

    public NormalBullet(Point point, AbstractEnemy enemy) {
        super("out/production/Picture/Bullet/NormalBullet.png", point, enemy, Config.NORMAL_BULLET_STRENGTH, Config.NORMAL_BULLET_SPEED, Config.NORMAL_BULLET_TTL);
    }
    public void doDrawing(Graphics g) {
        super.update();
        drawBullet.draw(this, g);
    }
}

package entity.tile.Bullet;

import Config.Config;

import java.awt.*;
import entity.tile.Point;
import drawer.Bullet.*;
import entity.tile.enemy.AbstractEnemy;
import entity.tile.tower.AbstractTower;

public class NormalBullet extends AbstractBullet {

    public NormalBullet(Point point, AbstractEnemy enemy) {
        super(point, enemy, Config.NORMAL_BULLET_STRENGTH, Config.NORMAL_BULLET_SPEED, Config.NORMAL_BULLET_TTL);
    }
    public void doDrawing(Graphics g) {
        super.update();
        drawNormalBullet.draw(getPoint(), g);
    }
}

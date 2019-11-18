package entity.tile.enemy;

import Config.Config;
import drawer.Enemy.*;
import java.awt.*;
import entity.tile.Point;

public class NormalEnemy extends AbstractEnemy {
    public NormalEnemy(Point point, Point nextPoint) {
        super(point, nextPoint, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_REWARD);
    }
    public void doDrawing(Graphics g) {
        super.update();
        drawNormalEnemy.draw(this, g);
    }
}

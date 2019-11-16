package entity.tile.enemy;

import Config.Config;
import entity.tile.Road;
import entity.tile.Point;
import java.awt.*;
import drawer.Enemy.drawSmallerEnemy;

public class SmallerEnemy extends AbstractEnemy {
    public SmallerEnemy(Point point, Point nextPoint) {
        super(point, nextPoint, Config.SMALLER_ENEMY_HEALTH, Config.SMALLER_ENEMY_ARMOR, Config.SMALLER_ENEMY_SPEED, Config.SMALLER_ENEMY_REWARD);
    }

    @Override
    public void doDrawing(Graphics g) {
        super.update();
        drawSmallerEnemy.draw(this, g);
    }

}

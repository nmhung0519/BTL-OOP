package entity.tile.enemy;

import Config.Config;
import entity.tile.Road;
import entity.tile.Point;
import java.awt.*;

public class SmallerEnemy extends AbstractEnemy {
    public SmallerEnemy(Point point, Point nextPoint) {
        super("out/production/Picture/Enemy/SmallerEnemy.png" ,point, nextPoint, Config.SMALLER_ENEMY_HEALTH, Config.SMALLER_ENEMY_ARMOR, Config.SMALLER_ENEMY_SPEED, Config.SMALLER_ENEMY_REWARD);
    }
}

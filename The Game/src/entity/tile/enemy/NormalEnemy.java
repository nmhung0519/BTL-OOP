package entity.tile.enemy;

import Config.Config;
import java.awt.*;
import entity.tile.Point;

public class NormalEnemy extends AbstractEnemy {
    public NormalEnemy(Point point, Point nextPoint) {
        super("out/production/Picture/Enemy/NormalEnemy.png", point, nextPoint, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_REWARD);
    }
}

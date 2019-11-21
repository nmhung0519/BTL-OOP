package entity.tile.enemy;

import Config.Config;
import entity.tile.Point;
import java.awt.*;

public class BossEnemy extends AbstractEnemy {
    public BossEnemy(Point point, Point nextPoint) {
        super("out/production/Picture/Enemy/BossEnemy.png", point, nextPoint, Config.BOSS_ENEMY_HEALTH, Config.BOSS_ENEMY_ARMOR, Config.BOSS_ENEMY_SPEED, Config.BOSS_ENEMY_REWARD);
    }
}

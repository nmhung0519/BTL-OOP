package entity.tile.enemy;

import Config.Config;
import entity.tile.Point;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TankerEnemy extends AbstractEnemy {
    public TankerEnemy(Point point, Point nextPoint) {
        super("out/production/Picture/Enemy/TankerEnemy.png" ,point, nextPoint, Config.TANKER_ENEMY_HEALTH, Config.TANKER_ENEMY_ARMOR, Config.TANKER_ENEMY_SPEED, Config.TANKER_ENEMY_REWARD);
    }
}

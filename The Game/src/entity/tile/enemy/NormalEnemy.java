package entity.tile.enemy;

import Config.Config;

import java.awt.*;

public class NormalEnemy extends AbstractEnemy {

    public NormalEnemy(int posX, int posY) {
        super(posX, posY, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_REWARD);
    }

}

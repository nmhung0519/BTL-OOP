package entity.tile.enemy;

import Config.Config;

public class SmallerEnemy extends AbstractEnemy {
    public SmallerEnemy(int posX, int posY) {
        super(posX, posY, Config.SMALLER_ENEMY_HEALTH, Config.SMALLER_ENEMY_ARMOR, Config.SMALLER_ENEMY_SPEED, Config.SMALLER_ENEMY_REWARD);
    }
}

package entity.tile.enemy;

import Config.Config;

public class TankerEnemy extends AbstractEnemy {
    public TankerEnemy(int posX, int posY) {
        super(posX, posY, Config.TANKER_ENEMY_HEALTH, Config.TANKER_ENEMY_ARMOR, Config.TANKER_ENEMY_SPEED, Config.TANKER_ENEMY_REWARD);
    }
}

package entity.tile.enemy;

import Config.Config;

public class BossEnemy extends AbstractEnemy {
    public BossEnemy(int posX, int posY) {
        super(posX, posY, Config.BOSS_ENEMY_HEALTH, Config.BOSS_ENEMY_ARMOR, Config.BOSS_ENEMY_SPEED, Config.BOSS_ENEMY_REWARD);
    }

}

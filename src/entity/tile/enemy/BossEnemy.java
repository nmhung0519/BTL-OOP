package entity.tile.enemy;

import Config.Config;
import entity.tile.Point;
import drawer.Enemy.drawBossEnemy;
import java.awt.*;

public class BossEnemy extends AbstractEnemy {
    public BossEnemy(Point point, Point nextPoint) {
        super(point, nextPoint, Config.BOSS_ENEMY_HEALTH, Config.BOSS_ENEMY_ARMOR, Config.BOSS_ENEMY_SPEED, Config.BOSS_ENEMY_REWARD);
    }
    public void doDrawing(Graphics g) {
        super.update();
        drawBossEnemy.draw(this, g);
    }
}

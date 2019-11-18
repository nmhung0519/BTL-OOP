package drawer.Enemy;

import Config.Config;
import drawer.drawEntity;
import entity.tile.enemy.BossEnemy;

import java.awt.*;

public class drawBossEnemy implements drawEntity {
    public static void draw(BossEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.fillRect(enemy.getPosX() - 40, enemy.getPosY() - 40, (int)(80 * ((double)enemy.getHealth() / (double) Config.BOSS_ENEMY_HEALTH)), 5);
        g2d.setPaint(Color.BLACK);
        g2d.drawRect(enemy.getPosX() - 40, enemy.getPosY() - 40, 80, 5);
        g2d.setPaint(Color.cyan);
        g2d.fillOval(enemy.getPosX() - 30, enemy.getPosY() - 30, 60, 60);
    }
}

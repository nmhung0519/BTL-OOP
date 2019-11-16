package drawer.Enemy;

import drawer.drawEntity;
import entity.tile.enemy.BossEnemy;

import java.awt.*;

public class drawBossEnemy implements drawEntity {
    public static void draw(BossEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.cyan);
        g2d.fillOval(enemy.getPosX(), enemy.getPosY(), 60, 60);
    }
}

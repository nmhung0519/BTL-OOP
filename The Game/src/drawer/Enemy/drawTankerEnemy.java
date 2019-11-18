package drawer.Enemy;

import Config.Config;
import drawer.drawEntity;
import entity.tile.enemy.TankerEnemy;

import java.awt.*;

public class drawTankerEnemy implements drawEntity {
    public static void draw(TankerEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.fillRect(enemy.getPosX() - 40, enemy.getPosY() - 40, (int)(80 * ((double)enemy.getHealth() / (double) Config.TANKER_ENEMY_HEALTH)), 5);
        g2d.setPaint(Color.BLACK);
        g2d.drawRect(enemy.getPosX() - 40, enemy.getPosY() - 40, 80, 5);
        g2d.setPaint(Color.getHSBColor(96, 27, 31));
        g2d.fillOval(enemy.getPosX() - 30, enemy.getPosY() - 30, 60, 60);
    }
}

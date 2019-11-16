package drawer.Enemy;

import drawer.drawEntity;
import entity.tile.enemy.SmallerEnemy;

import java.awt.*;

public class drawSmallerEnemy implements drawEntity {
    public static void draw(SmallerEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.RED);
        g2d.fillOval(enemy.getPosX() - 25, enemy.getPosY() - 25, 50, 50);
    }
}

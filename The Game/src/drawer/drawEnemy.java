package drawer;

import Config.Config;
import Effect.AbstractEffect;
import entity.tile.enemy.AbstractEnemy;

import java.awt.*;

public class drawEnemy {
    public static void draw(Image img, AbstractEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.fillRect(enemy.getPosX() - 40, enemy.getPosY() - 55, (int)(80 * ((double)enemy.getHealth() / (double) enemy.getMaxHealth())), 5);
        g2d.setPaint(Color.BLACK);
        g2d.drawRect(enemy.getPosX() - 40, enemy.getPosY() - 55, 80, 5);
        int x = enemy.getNextPoint().getPosX() - enemy.getPosX();
        int y = enemy.getNextPoint().getPosY() - enemy.getPosY();
        double rad = Math.acos((double) - y / Math.sqrt((double)Math.pow(x, 2) + Math.pow(y, 2)));
        if (x < 0) rad = - rad;
        g2d.rotate(rad, enemy.getPosX(), enemy.getPosY());
        g2d.drawImage(img, enemy.getPosX() - img.getWidth(null)/2, enemy.getPosY() - img.getHeight(null)/2, null);
        g2d.rotate(-rad, enemy.getPosX(), enemy.getPosY());
    }
}

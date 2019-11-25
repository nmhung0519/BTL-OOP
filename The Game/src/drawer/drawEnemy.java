package drawer;

import Config.Config;
import Effect.AbstractEffect;
import entity.tile.enemy.AbstractEnemy;

import java.awt.*;

public class drawEnemy {
    public static void draw(Image img, AbstractEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.fillRect(enemy.getPosX() - 40, enemy.getPosY() - 45, (int)(80 * ((double)enemy.getHealth() / (double) enemy.getMaxHealth())), 5);
        g2d.setPaint(Color.BLACK);
        g2d.drawRect(enemy.getPosX() - 40, enemy.getPosY() - 45, 80, 5);
        int width = img.getWidth(null);

        g2d.drawImage(img, enemy.getPosX() - width/2, enemy.getPosY() - width/2, null);
    }
}

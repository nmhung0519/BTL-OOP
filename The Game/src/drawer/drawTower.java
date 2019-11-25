package drawer;

import entity.tile.enemy.AbstractEnemy;
import entity.tile.*;

import java.awt.*;
import entity.tile.Point;

public class drawTower {
    public static void draw(Image img, Image gun, Point point, AbstractEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x = 1;
        int y = 0;
        double rad = 0;
        g2d.drawImage(img, point.getPosX() - (img.getHeight(null)/2), point.getPosY() - (img.getWidth(null)/2), null);
        if (enemy != null) {
            x = enemy.getPosX() - point.getPosX();
            y = enemy.getPosY() - point.getPosY();
            rad = Math.acos((double) -y / Math.sqrt((double) Math.pow(x, 2) + Math.pow(y, 2)));
            if (x < 0) rad = -rad;
            g2d.rotate(rad, point.getPosX(), point.getPosY());
            g2d.drawImage(gun, point.getPosX() - 32, point.getPosY() - 32, null);
            g2d.rotate(-rad, point.getPosX(), point.getPosY());
        }
        else {
            g2d.rotate(rad, point.getPosX(), point.getPosY());
            g2d.drawImage(gun, point.getPosX() - (gun.getHeight(null)/2), point.getPosY() - (gun.getWidth(null)/2), null);
            g2d.rotate(-rad, point.getPosX(), point.getPosY());
        }
    }
}

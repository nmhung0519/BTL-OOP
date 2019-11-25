package drawer.Tower;

import drawer.drawEntity;

import java.awt.*;
import entity.tile.Point;
import entity.tile.enemy.AbstractEnemy;

import javax.swing.*;

public class drawNormalTower implements drawEntity {
    public static void draw(Point point, AbstractEnemy enemy, Graphics2D g) {
        Image img = new ImageIcon("out/production/Picture/Tower/NormalTower.png").getImage();
        g.drawImage(img, point.getPosX() - 32, point.getPosY() - 32, null);
        Image gun = new ImageIcon("out/production/Picture/Tower/NormalTower_Gun.png").getImage();
        int x = 1;
        int y = 0;
        double rad = 0;
        if (enemy != null) {
            x = enemy.getPosX() - point.getPosX();
            y = enemy.getPosY() - point.getPosY();
            rad = Math.acos((double) -y / Math.sqrt((double) Math.pow(x, 2) + Math.pow(y, 2)));
            if (x < 0) rad = -rad;
            g.rotate(rad, point.getPosX(), point.getPosY());
            g.drawImage(gun, point.getPosX() - 32, point.getPosY() - 32, null);
            g.rotate(-rad, point.getPosX(), point.getPosY());
        }
        else {
            g.rotate(rad, point.getPosX(), point.getPosY());
            g.drawImage(gun, point.getPosX() - 32, point.getPosY() - 32, null);
            g.rotate(-rad, point.getPosX(), point.getPosY());
        }
    }
}

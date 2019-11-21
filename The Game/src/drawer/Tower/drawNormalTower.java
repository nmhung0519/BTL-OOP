package drawer.Tower;

import drawer.drawEntity;

import java.awt.*;
import entity.tile.Point;

import javax.swing.*;

public class drawNormalTower implements drawEntity {
    public static void draw(Point point, Graphics2D g) {
        Image img = new ImageIcon("out/production/Picture/Tower/NormalTower.png").getImage();
        g.drawImage(img, point.getPosX() - 32, point.getPosY() - 32, null);
        Image gun = new ImageIcon("out/production/Picture/Tower/NormalTower_Gun.png").getImage();
        g.drawImage(gun, point.getPosX() - 32, point.getPosY() - 32, null);
    }
}

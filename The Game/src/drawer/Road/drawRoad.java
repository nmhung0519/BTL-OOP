package drawer.Road;

import Config.Config;
import drawer.drawEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class drawRoad implements drawEntity {
    public static void draw(int posX, int posY, Graphics g) {
        Graphics g2d = (Graphics2D) g;
        Image img = new ImageIcon("out/production/Picture/Map/Road.png").getImage();
        g2d.drawImage(img, posX, posY, null);
    }
}
package drawer.Bullet;

import drawer.drawEntity;
import entity.tile.Bullet.AbstractBullet;
import entity.tile.Point;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;


public class drawNormalBullet implements drawEntity {
    public static void draw(Image img, AbstractBullet bullet, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x = bullet.getEnemy().getPosX() - bullet.getPosX();
        int y = bullet.getEnemy().getPosY() - bullet.getPosY();
        double rad = Math.acos((double) - y / Math.sqrt((double)Math.pow(x, 2) + Math.pow(y, 2)));
        if (x < 0) rad = - rad;
        g2d.rotate(rad, bullet.getPosX(), bullet.getPosY());
        g2d.drawImage(img, bullet.getPosX() - img.getWidth(null)/2, bullet.getPosY() - img.getHeight(null)/2, null);
        g2d.rotate(-rad, bullet.getPosX(), bullet.getPosY());
    }
}
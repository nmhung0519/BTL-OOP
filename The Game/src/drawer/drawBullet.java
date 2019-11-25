package drawer;

import entity.tile.Bullet;

import java.awt.*;

public class drawBullet {
    public static void draw(Bullet bullet, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x = bullet.getEnemy().getPosX() - bullet.getPosX();
        int y = bullet.getEnemy().getPosY() - bullet.getPosY();
        Image img = bullet.getImg();
        double rad = Math.acos((double) - y / Math.sqrt((double)Math.pow(x, 2) + Math.pow(y, 2)));
        if (x < 0) rad = - rad;
        g2d.rotate(rad, bullet.getPosX(), bullet.getPosY());
        g2d.drawImage(img, bullet.getPosX() - img.getWidth(null)/2, bullet.getPosY() - img.getHeight(null)/2, null);
        g2d.rotate(-rad, bullet.getPosX(), bullet.getPosY());
    }
}

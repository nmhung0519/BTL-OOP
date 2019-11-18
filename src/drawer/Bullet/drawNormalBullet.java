package drawer.Bullet;

import drawer.drawEntity;
import entity.tile.Point;

import java.awt.*;

public class drawNormalBullet implements drawEntity {
    public static void draw(Point point, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        g2d.fillOval(point.getPosX(), point.getPosY(), 10, 10);
    }

}

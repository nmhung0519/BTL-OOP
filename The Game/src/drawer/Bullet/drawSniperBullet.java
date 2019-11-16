package drawer.Bullet;

import drawer.drawEntity;
import entity.tile.Point;
import java.awt.*;

public class drawSniperBullet implements drawEntity {
    public static void draw(Point point, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.magenta);
        g2d.fillOval(point.getPosX(), point.getPosY(), 10, 10);
    }
}

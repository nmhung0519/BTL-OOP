package drawer.Tower;

import drawer.drawEntity;

import entity.tile.Point;
import java.awt.*;

public class drawMachineGunTower implements drawEntity {
    public static void draw(Point point, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.cyan);
        g2d.fillRoundRect(point.getPosX() - 30, point.getPosY() - 30, 60, 60, 40, 40);
    }
}

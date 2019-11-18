package drawer.Tower;

import drawer.drawEntity;

import java.awt.*;
import entity.tile.Point;

public class drawNormalTower implements drawEntity {
    public static void draw(Point point, Graphics2D g) {
        g.setPaint(Color.BLUE);
        g.fillRoundRect(point.getPosX() - 30, point.getPosY() - 30, 60, 60, 40, 40);
    }
}

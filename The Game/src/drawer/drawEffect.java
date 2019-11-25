package drawer;

import java.awt.*;
import entity.tile.Point;

public class drawEffect {
    public static void draw(Image img,  Point point, Graphics g) {
        Graphics g2d = (Graphics2D) g;
        g2d.drawImage(img, point.getPosX() - (img.getHeight(null)/2), point.getPosY() - (img.getWidth(null)/2), null);
    }
}

package drawer.Road;

import Config.Config;
import drawer.drawEntity;

import java.awt.*;

public class drawTarget implements drawEntity {
    public static void draw(int posX, int posY, Graphics2D g) {
        g.setPaint(Color.RED);
        g.fillRect(posX, posY, Config.ROAD_SIZE, Config.ROAD_SIZE);
    }
}

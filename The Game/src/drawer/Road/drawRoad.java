package drawer.Road;

import Config.Config;
import drawer.drawEntity;

import java.awt.*;

public class drawRoad implements drawEntity {
    public static void draw(int posX, int posY, Graphics2D g) {
        g.setPaint(Color.gray);
        g.fillRect(posX, posY, Config.ROAD_SIZE, Config.ROAD_SIZE);
    }
}

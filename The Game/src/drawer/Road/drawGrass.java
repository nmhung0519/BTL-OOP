package drawer.Road;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class drawGrass {
    public static void draw(int posX, int posY, Graphics2D g2d) {
        Image img = new ImageIcon("out/production/Picture/Map/Grass.png").getImage();
        g2d.drawImage(img, posX, posY, null);
    }
}

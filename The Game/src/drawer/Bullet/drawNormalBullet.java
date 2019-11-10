package drawer.Bullet;

import drawer.drawEntity;

import java.awt.*;

public class drawNormalBullet implements drawEntity {
    public void draw(int posX, int posY, Graphics2D g) {
        g.setPaint(Color.blue);
        g.fillOval(posX, posY, 12, 12);
    }
}

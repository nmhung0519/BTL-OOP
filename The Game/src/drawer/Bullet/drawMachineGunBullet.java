package drawer.Bullet;

import drawer.drawEntity;

import java.awt.*;

public class drawMachineGunBullet implements drawEntity {
    public void draw(int posX, int posY, Graphics2D g) {
        g.setPaint(Color.getColor("#483D8B"));
        g.fillOval(posX, posY, 9, 9);
    }
}

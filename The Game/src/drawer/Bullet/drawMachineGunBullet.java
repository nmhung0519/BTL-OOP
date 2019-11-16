package drawer.Bullet;

import drawer.drawEntity;

import java.awt.*;

public class drawMachineGunBullet implements drawEntity {
    public static void draw(int posX, int posY, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.fillOval(posX, posY, 9, 9);
    }
}

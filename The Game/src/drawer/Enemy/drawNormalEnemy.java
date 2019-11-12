package drawer.Enemy;

import drawer.drawEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class drawNormalEnemy extends JPanel implements drawEntity {
    public static void draw(int posX, int posY, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.yellow);
        g2d.fillOval(posX, posY, 60, 60);
    }

}

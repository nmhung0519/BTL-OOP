package drawer.Enemy;

import drawer.drawEntity;
import entity.tile.enemy.NormalEnemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class drawNormalEnemy extends JPanel implements drawEntity {
    public static void draw(NormalEnemy enemy, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.yellow);
        g2d.fillOval(enemy.getPosX() - 30, enemy.getPosY() - 30, 60, 60);
    }
}

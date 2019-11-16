package drawer.Enemy;

import Config.Config;
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
        g2d.setPaint(Color.red);
        g2d.fillRect(enemy.getPosX() - 40, enemy.getPosY() - 43, (int)(80 * ((double)enemy.getHealth() / (double)Config.NORMAL_ENEMY_HEALTH)), 5);
        g2d.setPaint(Color.BLACK);
        g2d.drawRect(enemy.getPosX() - 40, enemy.getPosY() - 43, 80, 5);
        g2d.setPaint(Color.yellow);
        g2d.fillOval(enemy.getPosX() - 30, enemy.getPosY() - 30, 60, 60);
    }
}

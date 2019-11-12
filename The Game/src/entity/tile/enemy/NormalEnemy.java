package entity.tile.enemy;

import Config.Config;
import drawer.Enemy.*;
import entity.tile.Road;

import javax.swing.*;
import java.awt.event.ActionListener;

import java.awt.*;
import entity.tile.Point;
import java.awt.event.ActionEvent;

public class NormalEnemy extends AbstractEnemy {

    public NormalEnemy(Point point, Point nextPoint) {
        super(point, nextPoint, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_REWARD);
    }
    public void doDrawing(Graphics g) {
        super.update();
        drawNormalEnemy.draw(super.getPosX(), super.getPosY(), g);
    }
}

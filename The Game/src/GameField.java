import entity.GameEntity;
import entity.tile.GameTile;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.Timer;


import drawer.*;
import drawer.Road.*;
import drawer.Bullet.*;
import drawer.Enemy.*;
import drawer.Tower.*;
import entity.tile.*;
import entity.tile.enemy.AbstractEnemy;
import entity.tile.enemy.*;
import entity.tile.tower.*;
import entity.tile.Bullet.*;
import entity.tile.Point;

class DragMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        JComponent c = (JComponent) e.getSource();
        TransferHandler handler = c.getTransferHandler();
        handler.exportAsDrag(c, e, TransferHandler.COPY);
    }
}
class Surface extends JPanel implements ActionListener{
    private GameStage gameStage;
    private int HP;
    private int REWARD;

    public Surface(GameStage gameStage) {
        this.gameStage = gameStage;
        HP = 5;
        REWARD = 20;
        initTimer();
    }

    private void initTimer() {
        Timer timer = new Timer(20, this);
        timer.start();
    }
    public Point nextPoint(Point p) {
        System.out.println(p.getPosX() + " - " + p.getPosY());
        for (int i = 0; i < gameStage.getRoads().length; i++) {
            if (p.equals(gameStage.getRoads()[i].getPoint())) {
                if (i < gameStage.getRoads().length - 1) return new Point(gameStage.getRoads()[i + 1].getPoint());
            }
        }
        return null;
    }
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.fillRect(550, 800, 80, 80);
        //g2d.setPaint(Color.GRAY);
        //g2d.fillRect(950, 800, 80, 80);
        gameStage.getSpawer().doDrawing(g2d);
        gameStage.getTarget().doDrawing(g2d);
        for (Road road : gameStage.getRoads()) {
            road.doDrawing(g);
        }
        for (AbstractEnemy enemy : gameStage.getEnimies()) {
            if (enemy.getPoint().equals(enemy.getNextPoint())) {
                Point tmp = nextPoint(enemy.getNextPoint());
                if (tmp == null) {
                    HP--;
                    REWARD += enemy.getReward();
                    gameStage.getEnimies().remove(enemy);
                }
                else enemy.setNextPoint(tmp);
            }
            enemy.doDrawing(g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class GameField extends JFrame {
    public GameField() throws FileNotFoundException {
        initUI();
    }
    private void initUI() throws FileNotFoundException {
        // Đường link đến file
        final Surface surface = new Surface(GameStage.load("C:\\Users\\ASUS\\IdeaProjects\\The Game\\src\\demo.txt"));
        add(surface);
        setTitle("Tower Defense");
        setBackground(Color.green);
        setSize(1200, 1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) throws FileNotFoundException {
        new GameField();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameField gameField = null;
                try {
                    gameField = new GameField();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                gameField.setVisible(true);
            }
        });
    }
}

import Config.Config;
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
import entity.tile.Bullet.*;
import entity.tile.enemy.*;
import entity.tile.tower.*;
import entity.tile.Bullet.*;
import entity.tile.Point;
import java.awt.Font;

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
    private int count;
    private List<AbstractEnemy> enemies;
    private List<AbstractBullet> bullets;
    private List<AbstractTower> towers;
    private Point point;
    private int spawnTower;

    public Surface(GameStage gameStage) {
        this.gameStage = gameStage;
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        towers = new ArrayList<>();
        towers.add(new NormalTower(50, 50));
        towers.add(new SniperTower(550, 550));
        towers.add(new MachineGunTower(650, 550));
        point = new Point(600, 600);
        spawnTower = 0;
        HP = 5;
        REWARD = 2;
        count = 0;
        addMouseListener(new MouseAdapter() {
            public int check(int x, int y) {
                if (y <= 950 && y >= 890 ) {
                    if (x >= 170 && x <= 230) return 1;
                    else if (x >= 570 && x <= 630) return 2;
                    else if (x >= 970 && x <= 1030) return 3;
                }
                return 0;
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (check(e.getX(), e.getY()) == 0) {
                    point.setPosX((e.getX() / 100) * 100 + 50);
                    point.setPosY((e.getY() / 100) * 100 + 50);
                    if (spawnTower == 1) towers.add(new NormalTower(point.getPosX(), point.getPosY()));
                    else if (spawnTower == 2) towers.add(new MachineGunTower(point.getPosX(), point.getPosY()));
                    else if (spawnTower == 3) towers.add(new SniperTower(point.getPosX(), point.getPosY()));
                    REWARD -= spawnTower;
                    spawnTower = 0;
                }
                else {
                    int tmp = check(e.getX(), e.getY());
                    if (spawnTower == tmp) spawnTower = 0;
                    else if (REWARD >= tmp) {
                        spawnTower = tmp;
                    }
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                point.set(e.getPoint());
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                if (e.getY() >= 850) point.set(e.getPoint());
                else {
                    point.setPosX((e.getX() / 100) * 100 + 50);
                    point.setPosY((e.getY() / 100) * 100 + 50);
                }
            }
        });
        initTimer();
    }

    private void initTimer() {
        Timer timer = new Timer(8, this);
        timer.start();
    }
    public Point nextPoint(Point p) {
        for (int i = 0; i < gameStage.getRoads().length; i++) {
            if (p.equals(gameStage.getRoads()[i].getPoint())) {
                if (i < gameStage.getRoads().length - 1) return new Point(gameStage.getRoads()[i + 1].getPoint());
            }
        }
        return null;
    }
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.gray);
        g2d.fillRect(970, 0, 200, 80);
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2d.drawString("REWARD: " + REWARD, 980, 48);
        g2d.drawLine(0, 850, 1200, 850);
        drawNormalTower.draw(new Point(200, 920), g2d);
        drawMachineGunTower.draw(new Point(600, 920), g2d);
        drawSniperTower.draw(new Point(1000, 920), g2d);
        gameStage.getSpawer().doDrawing(g2d);
        gameStage.getTarget().doDrawing(g2d);
        for (Road road : gameStage.getRoads()) {
            road.doDrawing(g);
        }
        if (count % 300 == 0) {
            enemies.add(new SmallerEnemy(new Point(gameStage.getSpawer().getPoint()), new Point(gameStage.getRoads()[1].getPoint())));
        }
        if (count % 200 == 0) {
            NormalEnemy tmp = new NormalEnemy(new Point(gameStage.getSpawer().getPoint()), new Point(gameStage.getRoads()[1].getPoint()));
            enemies.add(tmp);

        }
        for (AbstractTower tower : towers) {
            if (count % 50 == 0)
                for (AbstractEnemy enemy : enemies) {
                     if (tower.inDistance(enemy.getPoint())) {
                        bullets.add(tower.spawnBullet(enemy));
                        break;
                     }
            }
            tower.doDrawing(g);
        }
        for (AbstractBullet bullet : bullets) {
            bullet.doDrawing(g);
            bullet.Catch();
            if (!bullet.life()) bullets.remove(bullet);
        }
        for (AbstractEnemy enemy : enemies) {
            boolean life = enemy.life();
            if (life) {
                if (enemy.getPoint().equals(enemy.getNextPoint())) {
                    Point tmp = nextPoint(enemy.getNextPoint());
                    if (tmp == null) {
                        HP--;
                        enemies.remove(enemy);
                        life = false;
                    } else enemy.setNextPoint(tmp);
                }
                if (life) enemy.doDrawing(g);
            }
            else {
                REWARD += enemy.getReward();
                if (REWARD > 99) REWARD = 99;
                enemies.remove(enemy);
            }
        }
        if (spawnTower == 1) {
            drawNormalTower.draw(point, g2d);
            g2d.setPaint(Color.PINK);
            g2d.drawOval(point.getPosX() - Config.NORMAL_TOWER_RANGE, point.getPosY() - Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_RANGE * 2, Config.NORMAL_TOWER_RANGE * 2);
        }
        else if (spawnTower == 2) {
            drawMachineGunTower.draw(point, g2d);
            g2d.setPaint(Color.PINK);
            g2d.drawOval(point.getPosX() - Config.MACHINEGUN_TOWER_RANGE, point.getPosY() - Config.MACHINEGUN_TOWER_RANGE, Config.MACHINEGUN_TOWER_RANGE * 2, Config.MACHINEGUN_TOWER_RANGE * 2);
        }
        else if (spawnTower == 3) {
            drawSniperTower.draw(point, g2d);
            g2d.setPaint(Color.PINK);
            g2d.drawOval(point.getPosX() - Config.SNIPER_TOWER_RANGE, point.getPosY() - Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_RANGE * 2, Config.SNIPER_TOWER_RANGE * 2);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            count++;
            count = count % 1000;
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

import Config.Config;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

import Effect.AbstractEffect;
import Effect.Smoke;
import entity.tile.*;
import entity.tile.enemy.AbstractEnemy;
import entity.tile.Bullet.*;
import entity.tile.enemy.*;
import entity.tile.*;
import entity.tile.Point;
import java.awt.Font;
import drawer.Road.*;
import drawer.drawTower;

class Surface extends JPanel implements ActionListener{
    private GameStage gameStage;
    private int HP;
    private int REWARD;
    private int count;
    private List<AbstractEnemy> enemies;
    private List<AbstractBullet> bullets;
    private List<Tower> towers;
    private Point point;
    private int spawnTower;
    private int type;
    private int num;
    private File text;
    private Scanner scanner;
    private int countSpawn;
    private GameTile[][] map;
    private int trangThai;
    private Point point0;
    private List<AbstractEffect> effects;
    private Image normalTower, machineGunTower, sniperTower, normalTower_Gun, machineGunTower_Gun, sniperTower_Gun;

    public Surface(GameStage gameStage) throws FileNotFoundException {
        this.gameStage = gameStage;
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        towers = new ArrayList<>();
        effects = new ArrayList<>();
        point = new Point(600, 600);
        point0 = new Point(0 ,0);
        spawnTower = 0;
        num = 0;
        HP = 1;
        REWARD = 8;
        count = 0;
        type = 1;
        normalTower = new ImageIcon("out/production/Picture/Tower/NormalTower.png").getImage();
        normalTower_Gun = new ImageIcon("out/production/Picture/Tower/NormalTower_Gun.png").getImage();
        machineGunTower = new ImageIcon("out/production/Picture/Tower/MachineGunTower.png").getImage();
        machineGunTower_Gun = new ImageIcon("out/production/Picture/Tower.MachineGunTower_Gun.png").getImage();
        sniperTower = new ImageIcon("out/production/Picture/Tower/SniperTower.png").getImage();
        sniperTower_Gun = new ImageIcon("out/production/Picture/Tower/SniperTower_Gun.png").getImage();
        map = new GameTile[12][12];
        trangThai = 0;
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 12; j++) map[i][j] = null;
        try {
            File text = new File("C:\\Users\\ASUS\\IdeaProjects\\The Game\\src\\Enemy.txt");
            scanner = new Scanner(text);
        } catch (Exception e) {
            System.out.println(" + " + e);
        }
        for (Road road : gameStage.getRoads()) {
            map[(road.getPosX() - 50) / 100][(road.getPosY() - 50) / 100] = road;
        }
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
                if (trangThai == 0) {
                    if (e.getX() >= 400 && e.getX() <= 700 && e.getY() >= 400 && e.getY() <= 500) {
                        trangThai = 1;
                        repaint();
                    }
                } else if (trangThai == 1) {
                    if (check(e.getX(), e.getY()) == 0) {
                        if (e.getY() < 800) {
                            point.setPosX((e.getX() / 100) * 100 + 50);
                            point.setPosY((e.getY() / 100) * 100 + 50);
                            if (map[(point.getPosX() - 50) / 100][(point.getPosY() - 50) / 100] == null) {
                                 Tower tower = null;
                                if (spawnTower == 1) tower = new Tower(normalTower, normalTower_Gun, point.getPosX(), point.getPosY(), Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_SPEED) ;
                                else if (spawnTower == 2)
                                    tower = new Tower(machineGunTower, machineGunTower_Gun, point.getPosX(), point.getPosY(), Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED);
                                else if (spawnTower == 3) tower = new Tower(sniperTower, sniperTower_Gun, point.getPosX(), point.getPosY(), Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED);
                                if (tower != null) towers.add(tower);
                                REWARD -= spawnTower;
                                spawnTower = 0;
                                map[(point.getPosX() - 50) / 100][(point.getPosY() - 50) / 100] = tower;
                            }
                            else {
                                if (map[(point.getPosX() - 50) / 100][(point.getPosY() - 50) / 100] instanceof Tower) {
                                    Tower tmp = (Tower) map[(point.getPosX() - 50) / 100][(point.getPosY() - 50) / 100];
                                    towers.remove(tmp);
                                    map[(point.getPosX() - 50) / 100][(point.getPosY() - 50) / 100] = null;
                                }
                            }
                        }
                    } else {
                        int tmp = check(e.getX(), e.getY());
                        if (spawnTower == tmp) spawnTower = 0;
                        else if (REWARD >= tmp) {
                            spawnTower = tmp;
                        }
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
                point0.set(e.getPoint());
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
        Timer timer = new Timer(30, this);
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
    private void doDrawing(Graphics g) throws IOException {
        Graphics2D g2d = (Graphics2D) g;
        gameStage.getSpawer().doDrawing(g2d);
        gameStage.getTarget().doDrawing(g2d);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (map[i][j] instanceof Road) drawRoad.draw(i*100, j*100, g2d);
                else drawGrass.draw(i*100, j*100, g2d);
            }
        }
        if (trangThai == 0) {
            g2d.setPaint(Color.green);
            g2d.fillRect(400, 400, 300, 100);
            g2d.setPaint(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40));
            g2d.drawString("New Game", 450, 460);
        }
        else if (trangThai == 1) {
            g2d.setPaint(Color.gray);
            g2d.fillRect(970, 0, 200, 80);
            g2d.fillRect(830, 0, 110, 80);
            g2d.setPaint(Color.BLACK);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g2d.drawString("REWARD: " + REWARD, 980, 48);
            g2d.drawString("HP: " + HP, 840, 48);
            g2d.drawLine(0, 850, 1200, 850);
            drawTower.draw(normalTower, normalTower_Gun, new Point(200, 920), null, g);
            drawTower.draw(machineGunTower, machineGunTower_Gun, new Point(600, 920), null, g);
            drawTower.draw(sniperTower, sniperTower_Gun, new Point(1000, 920), null, g);
            try {
                if (type != 0) {
                    if (num == 0) {
                        type = scanner.nextInt();
                        System.out.println(type);
                        if (type != 0) {
                            num = scanner.nextInt();
                            countSpawn = scanner.nextInt();
                        }
                    }
                    if (type != 0) if (count == countSpawn) {
                        count = 0;
                        if (type == 1)
                            enemies.add(new NormalEnemy(new Point(gameStage.getSpawer().getPoint()), new Point(gameStage.getRoads()[1].getPoint())));
                        else if (type == 2)
                            enemies.add(new SmallerEnemy(new Point(gameStage.getSpawer().getPoint()), new Point(gameStage.getRoads()[1].getPoint())));
                        else if (type == 3)
                            enemies.add(new TankerEnemy(new Point(gameStage.getSpawer().getPoint()), new Point(gameStage.getRoads()[1].getPoint())));
                        else if (type == 4)
                            enemies.add(new BossEnemy(new Point(gameStage.getSpawer().getPoint()), new Point(gameStage.getRoads()[1].getPoint())));
                        num--;
                    }
                } else {
                    if (enemies.isEmpty()) {
                        trangThai = 2;
                        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                        g2d.drawString("Congratulation! You Win!", 300, 300);
                    }
                }
            } catch (Exception e) {
                System.out.println(" - " + e);
            }
            for (AbstractBullet bullet : bullets) {
                bullet.doDrawing(g);
                bullet.Catch();
                if (!bullet.life()) bullets.remove(bullet);
            }
            for (Tower tower : towers) {
                if (tower.canShoot()) {
                    AbstractEnemy tmp = tower.targetEnemy(enemies);
                    if (tmp != null) bullets.add(tower.spawnBullet(tmp));
                }
                tower.doDrawing(g);
            }
            for (AbstractEffect effect : effects) {
                if (effect.life()) effect.doDrawing(g);
                else effects.remove(effect);
            }
            for (AbstractEnemy enemy : enemies) {
                boolean life = enemy.life();
                if (life) {
                    if (enemy.getPoint().equals(enemy.getNextPoint())) {
                        Point tmp = nextPoint(enemy.getNextPoint());
                        if (tmp == null) {
                            HP--;
                            if (HP == 0) {
                                trangThai = 3;
                                JLabel endGame = new JLabel("Game Over");
                                endGame.setLayout(null);
                                BufferedImage img = ImageIO.read(new File("out/production/Picture/Game Over.png"));
                                img.getScaledInstance(400, 100, Image.SCALE_SMOOTH);
                                ImageIcon icon = new ImageIcon(img);
                                endGame.setIcon(icon);
                                endGame.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                                endGame.setBounds(400, 400, 400, 100);
                                endGame.setSize(400, 100);
                                endGame.setText("Game Over");
                                endGame.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                                add(endGame);
                                break;
                            }
                            enemies.remove(enemy);
                            life = false;
                        } else enemy.setNextPoint(tmp);
                    }
                    if (life) enemy.doDrawing(g);
                } else {
                    REWARD += enemy.getReward();
                    if (REWARD > 99) REWARD = 99;
                    effects.add(new Smoke(enemy.getPoint()));
                    enemies.remove(enemy);
                }
            }
            if (spawnTower == 1) {
                drawTower.draw(normalTower, normalTower_Gun, point, null, g);
                g2d.setPaint(Color.red);
                g2d.drawOval(point.getPosX() - Config.NORMAL_TOWER_RANGE, point.getPosY() - Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_RANGE * 2, Config.NORMAL_TOWER_RANGE * 2);
            } else if (spawnTower == 2) {
                drawTower.draw(machineGunTower, machineGunTower_Gun, point, null, g);
                g2d.setPaint(Color.red);
                g2d.drawOval(point.getPosX() - Config.MACHINEGUN_TOWER_RANGE, point.getPosY() - Config.MACHINEGUN_TOWER_RANGE, Config.MACHINEGUN_TOWER_RANGE * 2, Config.MACHINEGUN_TOWER_RANGE * 2);
            } else if (spawnTower == 3) {
                drawTower.draw(sniperTower, sniperTower_Gun, point, null, g);
                g2d.setPaint(Color.red);
                g2d.drawOval(point.getPosX() - Config.SNIPER_TOWER_RANGE, point.getPosY() - Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_RANGE * 2, Config.SNIPER_TOWER_RANGE * 2);
            }
            g2d.drawString(point0.getPosX() + " - " + point0.getPosY(), point0.getPosX(), point0.getPosY());
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            doDrawing(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (trangThai == 1) count++;
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
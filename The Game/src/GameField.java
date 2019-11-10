import entity.GameEntity;
import entity.tile.GameTile;

import java.io.FileNotFoundException;
import java.util.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
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

class Surface extends JPanel {
    private GameStage gameStage;

    public Surface(GameStage gameStage) {
        this.gameStage = gameStage;
    }
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (GameTile tile : gameStage.getGameTiles()) {
            System.out.println(tile.getClass());
            tile.draw(g2d);
        }
        gameStage.getSpawer().draw(g2d);
        gameStage.getTarget().draw(g2d);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
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
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
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

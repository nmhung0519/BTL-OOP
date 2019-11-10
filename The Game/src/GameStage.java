import entity.tile.GameTile;
import entity.tile.Road;
import entity.tile.Spawner;
import entity.tile.Target;
import entity.tile.enemy.AbstractEnemy;
import entity.tile.enemy.NormalEnemy;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.tile.enemy.*;
import entity.tile.tower.MachineGunTower;
import entity.tile.tower.NormalTower;
import entity.tile.tower.SniperTower;

public class GameStage {
    private Spawner spawer;
    private Target target;
    private List<GameTile> gameTiles;
    public GameStage(Spawner spawner, Target target, List<GameTile> gameTiles) {
        this.spawer = spawner;
        this.target = target;
        this.gameTiles = gameTiles;
    }

    public List<GameTile> getGameTiles() {
        return this.gameTiles;
    }
    public Spawner getSpawer() {
        return this.spawer;
    }
    public Target getTarget() {
        return this.target;
    }
    public static GameStage load(String path) {
        List<GameTile> gameTiles = new ArrayList<>();
        try {
            File text = new File(path);
            Scanner scanner = new Scanner(text);
            try {
                int numOfRoad = scanner.nextInt();
                int posX = scanner.nextInt();
                int posY = scanner.nextInt();
                Spawner spawner = new Spawner(posX, posY);
                for (int i = 2;i < numOfRoad; i++) {
                    posX = scanner.nextInt();
                    posY = scanner.nextInt();
                    gameTiles.add(new Road(posX, posY));
                }
                posX = scanner.nextInt();
                posY = scanner.nextInt();
                Target target = new Target(posX, posY);
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    gameTiles.add(new NormalEnemy(spawner.getPosX(), spawner.getPosY()));
                }
                num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    gameTiles.add(new SmallerEnemy(spawner.getPosX(), spawner.getPosY()));
                }
                num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    gameTiles.add(new TankerEnemy(spawner.getPosX(), spawner.getPosY()));
                }
                num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    gameTiles.add(new BossEnemy(spawner.getPosX(), spawner.getPosY()));
                }
                scanner.close();
                return new GameStage(spawner, target, gameTiles);
            } catch (Exception e) {
                System.out.println(" " + e);
            }
        } catch (Exception e) {
            System.out.println(" " + e);
        }
        return null;
    }

}
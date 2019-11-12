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
import entity.tile.Point;

public class GameStage {
    private Spawner spawer;
    private Target target;
    private List<AbstractEnemy> enemies;
    private Road[] roads;
    public GameStage(Spawner spawner, Target target, Road[] roads, List<AbstractEnemy> enemies) {
        this.spawer = spawner;
        this.target = target;
        this.enemies = enemies;
        this.roads = roads;
    }

    public List<AbstractEnemy> getEnimies() {
        return this.enemies;
    }
    public Spawner getSpawer() {
        return this.spawer;
    }
    public Target getTarget() {
        return this.target;
    }
    public Road[] getRoads() {
        return this.roads;
    }
    public static GameStage load(String path) {
        List<AbstractEnemy> enemies = new ArrayList<>();
        Road[] roads;
        try {
            File text = new File(path);
            Scanner scanner = new Scanner(text);
            try {
                int numOfRoads = scanner.nextInt();
                roads = new Road[numOfRoads];
                int posX = scanner.nextInt();
                int posY = scanner.nextInt();
                Spawner spawner = new Spawner(posX, posY);
                roads[0] = spawner;
                for (int i = 1;i < numOfRoads - 1; i++) {
                    posX = scanner.nextInt();
                    posY = scanner.nextInt();
                    roads[i] = new Road(posX, posY);
                }
                posX = scanner.nextInt();
                posY = scanner.nextInt();
                Target target = new Target(posX, posY);
                roads[numOfRoads - 1] = target;
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    enemies.add(new NormalEnemy(new Point(spawner.getPosX(), spawner.getPosY()), new Point(spawner.getPosX() , spawner.getPosY())));
                }
                num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    enemies.add(new SmallerEnemy(new Point(spawner.getPosX(), spawner.getPosY()), new Point(spawner.getPosX() , spawner.getPosY())));
                }
                num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    enemies.add(new TankerEnemy(new Point(spawner.getPosX(), spawner.getPosY()), new Point(spawner.getPosX() , spawner.getPosY())));
                }
                num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    enemies.add(new BossEnemy(new Point(spawner.getPosX(), spawner.getPosY()), new Point(spawner.getPosX() , spawner.getPosY())));
                }
                scanner.close();
                return new GameStage(spawner, target, roads,  enemies);
            } catch (Exception e) {
                System.out.println(" - " + e);
            }
        } catch (Exception e) {
            System.out.println(" + " + e);
        }
        return null;
    }

}
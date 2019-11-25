package Config;

import javax.swing.*;
import java.awt.*;

public final class Config {
    public static final int NORMAL_BULLET_TTL = 45;
    public static final int NORMAL_BULLET_STRENGTH = 18;
    public static final int NORMAL_BULLET_SPEED = 8;

    public static final int MACHINE_GUN_BULLET_TTL = 15;
    public static final int MACHINE_GUN_BULLET_STRENGTH = 12;
    public static final int MACHINE_GUN_BULLET_SPEED = 18;

    public static final int SNIPER_BULLET_TTL = 80;
    public static final int SNIPER_BULLET_STRENGTH = 35;
    public static final int SNIPER_BULLET_SPEED = 11;

    public static final int ROAD_SIZE = 100;

    public static final int NORMAL_ENEMY_HEALTH = 100;
    public static final int NORMAL_ENEMY_ARMOR = 4;
    public static final int NORMAL_ENEMY_SPEED = 2;
    public static final int NORMAL_ENEMY_REWARD = 1;

    public static final int SMALLER_ENEMY_HEALTH = 50;
    public static final int SMALLER_ENEMY_ARMOR = 0;
    public static final int SMALLER_ENEMY_SPEED = 4;
    public static final int SMALLER_ENEMY_REWARD = 2;

    public static final int TANKER_ENEMY_HEALTH = 300;
    public static final int TANKER_ENEMY_ARMOR = 8;
    public static final int TANKER_ENEMY_SPEED = 1;
    public static final int TANKER_ENEMY_REWARD = 3;

    public static final int BOSS_ENEMY_HEALTH = 2000;
    public static final int BOSS_ENEMY_ARMOR = 11;
    public static final int BOSS_ENEMY_SPEED = 1;
    public static final int BOSS_ENEMY_REWARD = 10;

    public static final int NORMAL_TOWER_SPEED = 20;
    public static final int NORMAL_TOWER_RANGE = 330;

    public static final int MACHINEGUN_TOWER_SPEED = 10;
    public static final int MACHINEGUN_TOWER_RANGE = 280;

    public static final int SNIPER_TOWER_SPEED = 40;
    public static final int SNIPER_TOWER_RANGE = 400;

    public static final Image[] SMOKE = new Image[5];
    static {
        SMOKE[1] = new ImageIcon("out/production/Picture/Effect/Smoke1.png").getImage();
        SMOKE[2] = new ImageIcon("out/production/Picture/Effect/Smoke2.png").getImage();
        SMOKE[3] = new ImageIcon("out/production/Picture/Effect/Smoke3.png").getImage();
        SMOKE[4] = new ImageIcon("out/production/Picture/Effect/Smoke4.png").getImage();
        SMOKE[5] = new ImageIcon("out/production/Picture/Effect/Smoke5.png").getImage();
    }
}

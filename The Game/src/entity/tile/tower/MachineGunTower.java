package entity.tile.tower;
import Config.Config;

public class MachineGunTower extends AbstractTower {

    public MachineGunTower(int posX, int posY) {
        super(posX, posY, Config.MACHINEGUN_TOWER_RANGE, Config.MACHINEGUN_TOWER_SPEED);
    }
}

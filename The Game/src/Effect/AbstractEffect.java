package Effect;

import entity.tile.Point;

import java.awt.*;

public abstract class AbstractEffect {
    protected int count;
    private Point point ;

    public AbstractEffect(Point point, int count) {
        this.point = new Point(point);
        this.count = count;
        for (int i = 0; i < count; i++);
    }
    public Point getPoint() {
        return this.point;
    }
    public int getPosX() {
        return this.point.getPosX();
    }
    public void setPosX(int posX) {
        this.point.setPosX(posX);
    }
    public int getPosY() {
        return this.point.getPosY();
    }
    public void setPosY(int posY) {
        this.point.setPosY(posY);
    }
    public void update() {
        count --;
    }
    public boolean life() {
        if (count > 3) return true;
        else return false;
    }
    public abstract void doDrawing(Graphics g) ;
}

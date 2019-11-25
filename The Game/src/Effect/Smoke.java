package Effect;

import entity.tile.Point;

import javax.swing.*;
import java.awt.*;
import drawer.drawEffect;

public class Smoke extends AbstractEffect{
    Image[] img;
    public Smoke(Point point) {
        super(point, 17);
        img = new Image[6];
        img[1] = new ImageIcon("out/production/Picture/Effect/Smoke1.png").getImage();
        img[2] = new ImageIcon("out/production/Picture/Effect/Smoke2.png").getImage();
        img[3] = new ImageIcon("out/production/Picture/Effect/Smoke3.png").getImage();
        img[4] = new ImageIcon("out/production/Picture/Effect/Smoke4.png").getImage();
        img[5] = new ImageIcon("out/production/Picture/Effect/Smoke5.png").getImage();
    }

    @Override
    public void doDrawing(Graphics g) {
        count--;
        drawEffect.draw(img[count/3], getPoint(), g);
    }
}

package lichtman.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Projectile p = new Projectile(0, 0, new Force(37.0365, 28.9360));

        //set origin to bottom left corner
        g.translate(0, getHeight());

        for (double i = 0; i < 5; i += 0.001) {
            p.apply(0.001);
            g.drawOval((int) p.getX(), (int) (-p.getY()), 5, 5);

        }
    }


    private void drawGravityOnForce(Graphics gg, double gx, double gy, double increment) {
        Force gf = new Force(gx, gy);
        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(increment);

        double x = 0;
        double y = 0;

        for (double i = 0; y >= 0; i++) {
            gf = gf.addForces(scaledGravity);
            Force scaledF1 = gf.scale(increment);
            x += scaledF1.getX();
            y += scaledF1.getY();

            gg.drawOval((int) x, ((int) -y), 2, 2);
        }
    }
}


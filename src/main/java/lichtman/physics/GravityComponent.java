package lichtman.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGravity(g, 37.0365, 28.9360, 1);
    }

    private void drawGravity(Graphics gg, double gx, double gy, double increment) {
        Force gf = new Force(gx, gy);
        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(increment);

        double x = 0;
        double y = 0;

        for (double i = 0; x >= 0; i += increment) {
            gf = gf.addForces(scaledGravity);
            Force scaledF1 = gf.scale(increment);
            x += scaledF1.getX();
            y += scaledF1.getY();



            gg.fillOval((int) x, (int) y, 1, 1);
        }
    }
}


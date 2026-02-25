package lichtman.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    private Force force = new Force(37.0365, 28.9360);
    private double time = 10;

    public void setTime(double d) {
        time = d;
    }

    public Force getForce() {
        return new Force(force.getX(), force.getY());
    }

    public void setForce(Force f) {
        force = f;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color green = new Color(50, 200, 0);
        g.setColor(green);

        Projectile p = new Projectile(0, 0, force);

        //set origin to bottom left corner
        g.translate(0, getHeight());

        for (double i = 0; i < time; i += 0.001) {
            p.apply(0.001);
            g.drawOval((int) p.getX(), (int) (-p.getY()), 5, 5);
        }

        g.drawLine(0, 0, (int) force.getX(), (int) force.getY());
    }
}


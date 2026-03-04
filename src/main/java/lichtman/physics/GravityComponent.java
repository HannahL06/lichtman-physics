package lichtman.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    private Force force;
    private double time;

    public GravityComponent() {
        force = new Force(0, 0);
        time = 10;
    }

    public void setTime(double d) {
        time = d;
    }

    public Force getForce() {
        return new Force(force.getX(), force.getY());
    }

    public void setForce(Force f) {
        force = new Force(f.getX(), f.getY());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //set origin to bottom left corner
        g.translate(0, getHeight());

        Color graphLineBlue = new Color(84, 200, 223);
        g.setColor(graphLineBlue);
        for (int i = 0; i < getHeight(); i += 20) {
            g.drawLine(0, -i, getWidth(), -i);
        }
        for (int i = 0; i < getWidth(); i += 20) {
            g.drawLine(i, -getHeight(), i, 0);
        }


        Projectile p = new Projectile(0, 0, force);
        Color green = new Color(50, 200, 0);
        g.setColor(green);

        for (double i = 0; i < time; i += 0.001) {
            p.apply(0.001);
            g.drawOval((int) p.getX(), (int) (-p.getY()), 5, 5);
        }
    }
}


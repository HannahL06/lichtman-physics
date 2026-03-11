package lichtman.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    private final Projectile p;
    private Force force;
    private double time;

    public GravityComponent() {
        force = new Force(50, 50);
        p = new Projectile(0, 0, force);
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

    public double getApex() {
        return -p.getApex()[1];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //set origin to bottom left corner
        g.translate(0, getHeight());

        Color graphLineBlue = new Color(84, 180, 223);
        g.setColor(graphLineBlue);
        for (int i = 0; i < getHeight(); i += 20) {
            g.drawLine(0, -i, getWidth(), -i);
        }
        for (int i = 0; i < getWidth(); i += 20) {
            g.drawLine(i, -getHeight(), i, 0);
        }

        //for (double i = 0; i < time; i += 0.001) {

        g.setColor(Color.DARK_GRAY);
        g.fillOval((int) (p.getApex()[0]), (int) (-p.getApex()[1]), 7, 7);

        g.setColor(Color.magenta);
        p.apply(0.03);
        g.fillOval((int) p.getX(), (int) (-p.getY()), 10, 10);

        //g.fillOval((int) p.getApex()[0], (int) -p.getApex()[1], 10, 10);

        //}
    }
}


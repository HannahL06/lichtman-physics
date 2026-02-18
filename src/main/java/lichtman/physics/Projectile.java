package lichtman.physics;

public class Projectile {
    public static final Force GRAVITY = new Force(0, -9.8);

    private Force force;
    private double x;
    private double y;

    public Projectile(double nX, double nY, Force nF) {
        x = nX;
        y = nY;
        force = nF;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Force getForce() {
        return force;
    }

    public void apply(double time) {
        Force scaledGravity = GRAVITY.scale(time);
        force = force.addForces(scaledGravity);
        Force scaledForce = force.scale(time);
        x += scaledForce.getX();
        y += scaledForce.getY();
    }
}

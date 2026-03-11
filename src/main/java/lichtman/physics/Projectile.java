package lichtman.physics;

public class Projectile {
    public static final Force GRAVITY = new Force(0, -9.8);
    private final double[] apexPoint = new double[2];
    private Force force;
    private double x;
    private double y;

    public Projectile(double nX, double nY, Force nF) {
        x = nX;
        y = nY;
        force = nF;
        calculateApex();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Force getForce() {
        return new Force(force.getX(), force.getY());
    }

    public void apply(double inc) {
        Force scaledGravity = GRAVITY.scale(inc);
        force = force.addForces(scaledGravity);
        Force scaledForce = force.scale(inc);
        x += scaledForce.getX();
        y += scaledForce.getY();
    }

    public double[] getApex() {
        return apexPoint;
    }

    private void calculateApex() {
        apexPoint[0] = (force.getY() / -GRAVITY.getY()) * (force.getX());
        apexPoint[1] = (force.getY() * force.getY()) / (2 * -GRAVITY.getY());
    }
}

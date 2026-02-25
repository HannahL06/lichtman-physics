package lichtman.physics;

public class Force {
    private final double magnitude;
    private final double degrees;
    private final double x;
    private final double y;

    public Force(double myX, double myY) {
        x = myX;
        y = myY;
        magnitude = Math.sqrt((x * x) + (y * y));
        degrees = Math.toDegrees(Math.atan2(y, x));
    }

    public double getMagnitude() {
        return magnitude;
    }

    public double getDegrees() {
        return degrees;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Force addForces(Force otherForce) {
        double newX = x + otherForce.getX();
        double newY = y + otherForce.getY();

        return new Force(newX, newY);
    }

    public String toString() {
        return "x= " + x + " , y= " + y + " magnitude= " + magnitude + " , degrees= " + degrees;
    }

    public Force scale(double scale) {
        return new Force((x * scale), (y * scale));
    }

    public Force normalize() {
        return new Force((x / magnitude), (y / magnitude));
    }

}
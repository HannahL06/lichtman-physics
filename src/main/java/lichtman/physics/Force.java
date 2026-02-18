package lichtman.physics;

public class Force {
    private double x;
    private double y;
    private final double magnitude;
    private final double degrees;

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

    /**
     * @return a new force
     */
    Force scale(double scale) {
        return new Force((x * scale), (y * scale));
    }


    /**
     * @return a new force proportionate to this force
     */
    Force normalize() {
        return new Force((x / magnitude), (y / magnitude));
    }

}
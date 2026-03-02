package lichtman.physics;

import javax.swing.*;

// controller job - takes input, modifies the model, and update the views.
public class GravityController {
    GravityComponent gravComp;
    JTextField xField = new JTextField("0.00");
    JTextField yField = new JTextField("0.00");
    JTextField tField = new JTextField("0");
    JLabel angleLabel = new JLabel(" ");
    JLabel magLabel = new JLabel(" ");

    public GravityController(GravityComponent gc) {
        gravComp = gc;
    }

    public void updateForce(double x, double y) {
        Force force = new Force(x, y);
        gravComp.setForce(force);
        gravComp.setTime(Double.parseDouble(tField.getText()));

        xField.setText(String.valueOf(x));
        yField.setText(String.valueOf(y));
        angleLabel.setText("Angle:" + String.format("%.2f", gravComp.getForce().getDegrees()));
        magLabel.setText("Magnitude: " + String.format("%.2f", gravComp.getForce().getMagnitude()));
    }
}

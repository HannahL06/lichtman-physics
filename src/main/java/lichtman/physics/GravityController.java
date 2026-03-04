package lichtman.physics;

import javax.swing.*;

// controller job - takes input, modifies the model, and update the views.
public class GravityController {
    private final GravityComponent gravComp;
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField tField;
    private final JLabel angleLabel;
    private final JLabel magLabel;


    public GravityController(GravityComponent gc, JTextField newtField, JTextField newxField, JTextField newyField,
                             JLabel aLabel, JLabel mLabel) {
        gravComp = gc;
        xField = newxField;
        yField = newyField;
        tField = newtField;
        angleLabel = aLabel;
        magLabel = mLabel;
    }

    public void updateForce(double x, double y) {
        gravComp.setForce(new Force(x, y));
        gravComp.setTime(Double.parseDouble(tField.getText()));
        angleLabel.setText("Angle:" + String.format("%.2f", gravComp.getForce().getDegrees()));
        magLabel.setText("Magnitude: " + String.format("%.2f", gravComp.getForce().getMagnitude()));
    }

    public void updateForceAtEvent(double x, double y) {
        gravComp.setForce(new Force(x, gravComp.getHeight() - y));
        xField.setText(String.valueOf(x));
        yField.setText(String.valueOf(y));
        angleLabel.setText("Angle:" + String.format("%.2f", gravComp.getForce().getDegrees()));
        magLabel.setText("Magnitude: " + String.format("%.2f", gravComp.getForce().getMagnitude()));
    }
}

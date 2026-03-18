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
    private final JLabel apexLabel;


    public GravityController(GravityComponent gc,
                             JTextField newtField,
                             JTextField newxField,
                             JTextField newyField,
                             JLabel aLabel,
                             JLabel mLabel,
                             JLabel apLabel) {
        gravComp = gc;
        xField = newxField;
        yField = newyField;
        tField = newtField;
        angleLabel = aLabel;
        magLabel = mLabel;
        apexLabel = apLabel;
    }

    public void updateForce(double x, double y) {
        Force force = new Force(x, y);
        gravComp.setForce(force);
        gravComp.setTime(Double.parseDouble(tField.getText()));
        xField.setText(String.valueOf(force.getX()));
        yField.setText(String.valueOf(force.getY()));
        angleLabel.setText("Angle: " + String.format("%.4f", force.getDegrees()));
        magLabel.setText("Magnitude: " + String.format("%.4f", force.getMagnitude()));
        apexLabel.setText("Apex: " + String.format("%.4f", -gravComp.getApex()));
    }
}

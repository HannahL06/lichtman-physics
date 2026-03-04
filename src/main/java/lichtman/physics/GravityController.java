package lichtman.physics;

import javax.swing.*;
import java.awt.event.MouseEvent;

// controller job - takes input, modifies the model, and update the views.
public class GravityController {
    private final GravityComponent gravComp;
    private final JTextField xField = new JTextField("50");
    private final JTextField yField = new JTextField("50");
    private final JTextField tField = new JTextField("15");
    private final JLabel angleLabel = new JLabel(" ");
    private final JLabel magLabel = new JLabel(" ");

    public GravityController(GravityComponent gc) {
        gravComp = gc;
    }

    public JTextField getxField() {
        return xField;
    }

    public JTextField getyField() {
        return yField;
    }

    public JTextField gettField() {
        return tField;
    }

    public JLabel getAngleLabel() {
        return angleLabel;
    }

    public JLabel getMagLabel() {
        return magLabel;
    }

    public void updateForce() {
        gravComp.setForce(new Force(
                Double.parseDouble(xField.getText()),
                Double.parseDouble(yField.getText()))
        );
        gravComp.setTime(Double.parseDouble(tField.getText()));
        angleLabel.setText("Angle:" + String.format("%.2f", gravComp.getForce().getDegrees()));
        magLabel.setText("Magnitude: " + String.format("%.2f", gravComp.getForce().getMagnitude()));
    }

    public void updateForceAtEvent(MouseEvent e) {
        gravComp.setForce(new Force(e.getX(), gravComp.getHeight() - e.getY()));
        xField.setText(String.valueOf(e.getX()));
        yField.setText(String.valueOf(e.getY()));
        angleLabel.setText("Angle:" + String.format("%.2f", gravComp.getForce().getDegrees()));
        magLabel.setText("Magnitude: " + String.format("%.2f", gravComp.getForce().getMagnitude()));
    }
}

package lichtman.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame {
    public GravityFrame() {
        setSize(600, 600);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        GravityComponent gravityComponent = new GravityComponent();

        JTextField xField = new JTextField("37.0365");
        JTextField yField = new JTextField("28.9360");
        JTextField tField = new JTextField("10");
        JButton button = new JButton("Draw");

        JLabel xLabel = new JLabel("X Field:");
        JLabel yLabel = new JLabel("Y Field:");
        JLabel tLabel = new JLabel("Time:");

        JLabel angleLabel = new JLabel("Angle:" + String.format("%.2f", gravityComponent.getForce().getDegrees()));
        JLabel magLabel = new JLabel("Magnitude: " + String.format("%.2f", gravityComponent.getForce().getMagnitude()));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityComponent.setForce(
                        new Force(
                                Double.parseDouble(xField.getText()),
                                Double.parseDouble(yField.getText())
                        ));
                gravityComponent.setTime(Double.parseDouble(tField.getText()));
                angleLabel.setText("Angle:" + String.format("%.2f", gravityComponent.getForce().getDegrees()));
                magLabel.setText("Magnitude: " + String.format("%.2f", gravityComponent.getForce().getMagnitude()));
            }
        });

        gravityComponent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Force force = new Force(e.getX(), gravityComponent.getHeight() - e.getY());
                xField.setText(String.valueOf(force.getX()));
                yField.setText(String.valueOf(force.getY()));
                gravityComponent.setForce(force);
                gravityComponent.setTime(Double.parseDouble(tField.getText()));
                angleLabel.setText("Angle:" + String.format("%.2f", gravityComponent.getForce().getDegrees()));
                magLabel.setText("Magnitude: " + String.format("%.2f", gravityComponent.getForce().getMagnitude()));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gravityComponent.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Force force = new Force(e.getX(), gravityComponent.getHeight() - e.getY());
                xField.setText(String.valueOf(force.getX()));
                yField.setText(String.valueOf(force.getY()));
                gravityComponent.setForce(force);
                gravityComponent.setTime(Double.parseDouble(tField.getText()));
                angleLabel.setText("Angle:" + String.format("%.2f", gravityComponent.getForce().getDegrees()));
                magLabel.setText("Magnitude: " + String.format("%.2f", gravityComponent.getForce().getMagnitude()));
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        JPanel northPanel = new JPanel();

        northPanel.add(xLabel);
        northPanel.add(xField);
        northPanel.add(yLabel);
        northPanel.add(yField);
        northPanel.add(tLabel);
        northPanel.add(tField);
        northPanel.add(button);
        northPanel.add(magLabel);
        northPanel.add(angleLabel);

        add(northPanel, BorderLayout.NORTH);
        add(gravityComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}


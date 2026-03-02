package lichtman.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// new Force(37.0365, 28.9360)

public class GravityFrame extends JFrame {
    public GravityFrame() {
        setSize(600, 600);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        GravityComponent gravityComponent = new GravityComponent(new Force(0, 0), 10);
        GravityController gravityController = new GravityController(gravityComponent);

        JTextField xField = new JTextField("0.00");
        JTextField yField = new JTextField("0.00");
        JTextField tField = new JTextField("10");
        JButton button = new JButton("Draw");

        JLabel xLabel = new JLabel("X Field:");
        JLabel yLabel = new JLabel("Y Field:");
        JLabel tLabel = new JLabel("Time:");

        JLabel angleLabel = new JLabel(" ");
        JLabel magLabel = new JLabel(" ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityController.updateForce(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText()));
            }
        });

        gravityComponent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gravityController.updateForce(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText()));
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
                gravityController.updateForce(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText()));
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


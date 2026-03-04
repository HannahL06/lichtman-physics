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

        JTextField xField = new JTextField("50");
        JTextField yField = new JTextField("50");
        JTextField tField = new JTextField("15");
        JLabel angleLabel = new JLabel(" ");
        JLabel magLabel = new JLabel(" ");

        JButton button = new JButton("Draw");
        JLabel xLabel = new JLabel("X Field:");
        JLabel yLabel = new JLabel("Y Field:");
        JLabel tLabel = new JLabel("Time:");

        GravityComponent gravityComponent = new GravityComponent();
        GravityController gravityController = new GravityController(gravityComponent, tField, xField, yField, angleLabel, magLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityController.updateForce(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText())
                );
            }
        });

        gravityComponent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gravityController.updateForceAtEvent(e.getX(), e.getY());
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
                gravityController.updateForceAtEvent(e.getX(), e.getY());
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


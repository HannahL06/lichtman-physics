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

        GravityComponent gravityComponent = new GravityComponent();
        GravityController gravityController = new GravityController(gravityComponent);

        JButton button = new JButton("Draw");
        JLabel xLabel = new JLabel("X Field:");
        JLabel yLabel = new JLabel("Y Field:");
        JLabel tLabel = new JLabel("Time:");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityController.updateForce();
            }
        });

        gravityComponent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gravityController.updateForceAtEvent(e);
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
                gravityController.updateForceAtEvent(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        JPanel northPanel = new JPanel();

        northPanel.add(xLabel);
        northPanel.add(gravityController.getXField());
        northPanel.add(yLabel);
        northPanel.add(gravityController.getYField());
        northPanel.add(tLabel);
        northPanel.add(gravityController.getTField());
        northPanel.add(button);
        northPanel.add(gravityController.getMagLabel());
        northPanel.add(gravityController.getAngleLabel());

        add(northPanel, BorderLayout.NORTH);
        add(gravityComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}


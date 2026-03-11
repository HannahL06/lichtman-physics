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

        JTextField xField = new JTextField("50");
        JTextField yField = new JTextField("50");
        JTextField tField = new JTextField("10");
        JLabel angleLabel = new JLabel(String.valueOf(gravityComponent.getForce().getDegrees()));
        JLabel magLabel = new JLabel(" ");
        JLabel apexLabel = new JLabel(" ");

        JButton button = new JButton("Draw");
        JLabel xLabel = new JLabel("X Field:");
        JLabel yLabel = new JLabel("Y Field:");
        JLabel tLabel = new JLabel("Time:");

        GravityController gravityController = new GravityController(
                gravityComponent, tField, xField,
                yField, angleLabel, magLabel, apexLabel
        );

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
                gravityController.updateForce(e.getX(), e.getY());
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
                gravityController.updateForce(e.getX(), e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    gravityComponent.repaint();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        JPanel westPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        westPanel.add(xLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        westPanel.add(xField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        westPanel.add(yLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        westPanel.add(yField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0.5;
        westPanel.add(tLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 0.5;
        westPanel.add(tField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.weightx = 0.5;
        westPanel.add(angleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.weightx = 0.5;
        westPanel.add(magLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.weightx = 0.5;
        westPanel.add(apexLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.weightx = 0.5;
        westPanel.add(button, constraints);

        add(westPanel, BorderLayout.WEST);
        add(gravityComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}


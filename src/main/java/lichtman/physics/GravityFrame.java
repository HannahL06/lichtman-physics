package lichtman.physics;

import javax.swing.*;
import java.awt.*;

public class GravityFrame extends JFrame {
    public GravityFrame() {
        setSize(600, 600);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(new GravityComponent());
    }



    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}


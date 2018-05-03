package app.components;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame {
    public ApplicationFrame(Container content) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(content);
        frame.pack();
        frame.setVisible(true);
    }
}

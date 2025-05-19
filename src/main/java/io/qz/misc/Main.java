package io.qz.misc;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("OpenUriTest");
            final JLabel label = new JLabel("Hello world!");
            label.setFont(label.getFont().deriveFont(24f));
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            // Fire an event when our URI is fired
            Desktop.getDesktop().setOpenURIHandler(e -> {
                SwingUtilities.invokeLater(() -> {
                    label.setText("Fired: " + e.getURI().toString());
                    label.setOpaque(true);
                    label.setBackground(new Color((int)(Math.random() * 0x1000000)));
                    frame.pack();
                });
            });
        });
    }
}
package com.ems.ui;

import java.awt.*;
import javax.swing.*;

// Splash screen shown at the start of the application
public class Splash extends JFrame {

    // Constructor
    Splash() {

        // Load image from resources
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));

        // Scale image to fit window
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);

        // Convert scaled image back to ImageIcon
        ImageIcon i3 = new ImageIcon(i2);

        // Add image to a JLabel
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);

        // Set frame properties
        setSize(1170, 650);                  // Set window size
        setLocationRelativeTo(null);         // Center the window
        setLayout(null);                     // Use absolute positioning
        setVisible(true);                    // Show the window

        // Hold splash screen for 5 seconds, then move to Login screen
        try {
            Thread.sleep(5000);              // Pause for 5 seconds
            setVisible(false);               // Hide splash screen
            new Login();                     // Launch Login window
        } catch (Exception e) {
            e.printStackTrace();             // Print any error during sleep or login launch
        }
    }
}

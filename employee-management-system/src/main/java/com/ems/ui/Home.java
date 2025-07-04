package com.ems.ui; // Declaring the package

// Importing required classes
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Main Home screen class for navigation, extends JFrame
public class Home extends JFrame {

    // Constructor to initialize the GUI
    Home() {

        // Load the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg")); // Load image from resource
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT); // Scale the image
        ImageIcon i3 = new ImageIcon(i2); // Convert back to ImageIcon
        JLabel image = new JLabel(i3); // Add image to a JLabel
        image.setBounds(0, 0, 1120, 630); // Set size of image to match frame
        add(image); // Add image label to the frame

        // Heading text on image
        JLabel heading = new JLabel("Employee Management System"); // Heading text
        heading.setBounds(340, 155, 400, 40); // Position the heading
        heading.setFont(new Font("Raleway", Font.BOLD, 25)); // Set font
        image.add(heading); // Add heading to image label

        // Create a border for buttons
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Add Employee Button
        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40); // Position the button
        add.setBackground(Color.BLACK); // Background color
        add.setForeground(Color.WHITE); // Text color
        add.setFont(new Font("Roboto", Font.BOLD, 14)); // Font
        add.setToolTipText("Click to add employee"); // Tooltip
        add.setBorder(border); // Add border
        // Action listener to navigate to AddEmployee page
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false); // Hide current frame
                new AddEmployee(); // Open AddEmployee frame
            }
        });
        image.add(add); // Add button to image label

        // View Employee Button
        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40); // Position the button
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Roboto", Font.BOLD, 14));
        view.setToolTipText("Click to view employee");
        view.setBorder(border);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new ViewEmployee(); // Open ViewEmployee frame
            }
        });
        image.add(view);

        // Remove Employee Button
        JButton remove = new JButton("Remove Employee");
        remove.setBounds(440, 370, 150, 40);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.setFont(new Font("Roboto", Font.BOLD, 14));
        remove.setToolTipText("Click to remove employee");
        remove.setBorder(border);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new RemoveEmployee(); // Open RemoveEmployee frame
            }
        });
        image.add(remove);

        // Set basic frame properties
        setSize(1120, 630); // Set window size
        setLocationRelativeTo(null); // Center the window
        setLayout(null); // No layout manager (absolute positioning)
        setVisible(true); // Make frame visible
    }
}

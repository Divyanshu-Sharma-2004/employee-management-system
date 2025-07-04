package com.ems.ui; // Defines the package where this class belongs

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.*;
import com.ems.dao.LoginDao; // Importing the DAO class for login validation

// Login class extends JFrame and handles login UI + logic
public class Login extends JFrame implements ActionListener {
    
    // Swing components declared
    JTextField usernameTF;
    JPasswordField passwordTF;
    JButton login, back;

    // Constructor: sets up the UI
    Login() {
        
        Font tfont = new Font("Tahoma", Font.BOLD, 12); // Font for text fields

        // Username Label
        JLabel username = new JLabel("Username:");
        username.setBounds(40, 20, 100, 30);
        add(username);

        // TextField border styling
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Username TextField
        usernameTF = new JTextField();
        usernameTF.setBounds(150, 20, 150, 30);
        usernameTF.setFont(tfont);
        usernameTF.setBorder(border);
        add(usernameTF);

        // Password Label
        JLabel password = new JLabel("Password:");
        password.setBounds(40, 70, 100, 30);
        add(password);

        // Password Field
        passwordTF = new JPasswordField();
        passwordTF.setBounds(150, 70, 150, 30);
        passwordTF.setFont(tfont);
        passwordTF.setBorder(border);
        add(passwordTF);

        // Login Button
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Roboto", Font.BOLD, 14));
        login.setToolTipText("Click to login"); // Tooltip
        login.setBorder(border);
        login.addActionListener(this);
        add(login);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Roboto", Font.BOLD, 14));
        back.setBorder(border);
        back.addActionListener(this);
        add(back);

        // Right-side decorative image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image2 = new JLabel(i33);
        image2.setBounds(350, 10, 600, 400);
        add(image2);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 300);
        add(image);

        // Frame settings
        setSize(600, 300); // Set frame size
        setLocationRelativeTo(null); // Center the frame
        setLayout(null); // Use absolute positioning
        setVisible(true); // Make frame visible
    }

    // Event handling for buttons
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            // Get text from input fields
            String username = usernameTF.getText();
            String password = new String(passwordTF.getPassword());

            // Validate using DAO
            LoginDao loginDao = new LoginDao();
            boolean isValid = loginDao.validateUser(username, password);

            if (isValid) {
                // If login successful
                setVisible(false);
                new Home(); // Open home screen
            } else {
                // If login fails
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } else if (ae.getSource() == back) {
            System.exit(0); // Close application on back
        }
    }
}

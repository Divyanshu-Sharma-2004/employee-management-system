package com.ems.ui;

// Import necessary packages
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import com.ems.dao.EmployeeDao;
import com.ems.model.EmployeeEntity;

// GUI class for removing employees
public class RemoveEmployee extends JFrame implements ActionListener {

    // UI components
    Choice choiceEMPID;
    JButton delete, back;

    // Constructor
    RemoveEmployee() {

        // Create a border for buttons
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Font to use in labels
        Font font = new Font("Tahoma", Font.BOLD, 15);

        // Label: Employee ID
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 100, 30);
        label.setFont(font);
        add(label);

        // Dropdown (Choice) for employee IDs
        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200, 50, 150, 30);
        add(choiceEMPID);

        // Populate employee IDs into Choice dropdown
        try {
            EmployeeDao dao = new EmployeeDao();
            List<String> empIds = dao.getAllEmployeeIds();

            if (empIds != null) {
                for (String id : empIds) {
                    choiceEMPID.add(id);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to fetch employee IDs.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Label and field: Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 100, 30);
        name.setFont(font);
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 100, 300, 30);
        tname.setFont(font);
        add(tname);

        // Label and field: Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 150, 100, 30);
        phone.setFont(font);
        add(phone);

        JLabel tphone = new JLabel();
        tphone.setBounds(200, 150, 100, 30);
        tphone.setFont(font);
        add(tphone);

        // Label and field: Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 200, 100, 30);
        email.setFont(font);
        add(email);

        JLabel temail = new JLabel();
        temail.setBounds(200, 200, 600, 30);
        temail.setFont(font);
        add(temail);

        // Fetch employee details on first load
        try {
            EmployeeDao dao = new EmployeeDao();
            EmployeeEntity emp = dao.getEmployeeById(choiceEMPID.getSelectedItem());

            if (emp != null) {
                tname.setText(emp.getName());
                tphone.setText(emp.getPhone());
                temail.setText(emp.getEmail());
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add listener to update name/phone/email when ID changes
        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    EmployeeDao dao = new EmployeeDao();
                    EmployeeEntity emp = dao.getEmployeeById(choiceEMPID.getSelectedItem());

                    if (emp != null) {
                        tname.setText(emp.getName());
                        tphone.setText(emp.getPhone());
                        temail.setText(emp.getEmail());
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // DELETE Button setup
        delete = new JButton("DELETE");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setToolTipText("Click to Delete Data");
        delete.setBorder(border);
        delete.addActionListener(this);
        add(delete);

        // BACK Button setup
        back = new JButton("BACK");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(border);
        back.addActionListener(this);
        add(back);

        // Right side icon (delete)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700, 80, 200, 200);
        add(image);

        // Background image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image2 = new JLabel(i33);
        image2.setBounds(0, 0, 1120, 630);
        add(image2);

        // JFrame settings
        setSize(1000, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Event handling for buttons
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                String empId = choiceEMPID.getSelectedItem(); // Get selected employee ID
                EmployeeDao dao = new EmployeeDao();

                boolean deleted = dao.deleteEmployee(empId); // Attempt deletion
                if (deleted) {
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                    setVisible(false);
                    new Home(); // Return to home screen
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found or error occurred.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // If BACK is clicked
            setVisible(false);
            new Home(); // Go back to home screen
        }
    }
}

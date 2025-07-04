package com.ems.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;
import java.util.List;

import com.ems.dao.EmployeeDao;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.ems.model.EmployeeEntity;

public class ViewEmployee extends JFrame implements ActionListener {

    // Components used in the frame
    Choice choiceEMP;              // Dropdown to select Employee ID
    JTable table;                  // Table to show employee details
    DefaultTableModel model;       // Model for the table data
    JButton searchB, print, update, back; // Buttons for actions

    // Constructor for setting up the UI
    ViewEmployee() {

        // Set background color
        getContentPane().setBackground(new Color(230, 230, 250));

        // Label for search
        JLabel search = new JLabel("Search by employee ID");
        search.setBounds(20, 20, 150, 20);
        add(search);

        // Choice dropdown for employee IDs
        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        // Populate employee IDs into the choice dropdown
        try {
            EmployeeDao dao = new EmployeeDao();
            List<String> empIds = dao.getAllEmployeeIds();

            if (empIds != null) {
                for (String id : empIds) {
                    choiceEMP.add(id);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to fetch employee IDs.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize table to show data
        table = new JTable();

        // ===== Style the table visually =====
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(20);
        table.setGridColor(new Color(220, 220, 220));  // Light gray grid lines
        table.setShowGrid(true);

        // ===== Customize table header =====
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBackground(new Color(0, 102, 204));   // Navy blue background
        header.setForeground(Color.WHITE);              // White text
        header.setReorderingAllowed(false);             // Prevent column dragging

        // Wrap table inside scroll pane
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 950, 600);
        sp.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Gray border
        add(sp);

        // Fetch and load all employee data into the table
        try {
            EmployeeDao dao = new EmployeeDao();
            List<EmployeeEntity> empList = dao.getAllEmployees();

            if (empList != null && !empList.isEmpty()) {
                // Define table column names
                String[] columnNames = {
                    "Employee ID", "Name", "Father's Name", "DOB", "Salary",
                    "Address", "Phone", "Email", "Education", "Designation", "Aadhar"
                };

                // Set up table model
                model = new DefaultTableModel(columnNames, 0);

                // Add employee rows
                for (EmployeeEntity emp : empList) {
                    model.addRow(new Object[]{
                        emp.getEmpId(), emp.getName(), emp.getFname(), emp.getDob(),
                        emp.getSalary(), emp.getAddress(), emp.getPhone(), emp.getEmail(),
                        emp.getEducation(), emp.getDesignation(), emp.getAadhar()
                    });
                }

                table.setModel(model);  // Apply model to table
            } else {
                JOptionPane.showMessageDialog(this, "No employee records found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ======= Buttons Section =======
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // Button border

        // Search Button
        searchB = new JButton("Search");
        searchB.setBounds(20, 70, 80, 20);
        searchB.setToolTipText("Search by ID");
        searchB.setBorder(border);
        searchB.addActionListener(this);
        add(searchB);

        // Print Button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setToolTipText("Print table");
        print.setBorder(border);
        print.addActionListener(this);
        add(print);

        // Update Button
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.setToolTipText("Update details of selected ID");
        update.setBorder(border);
        update.addActionListener(this);
        add(update);

        // Back Button
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.setBorder(border);
        back.addActionListener(this);
        add(back);

        // ======= Final Frame Settings =======
        setSize(950, 700);          // Window size
        setLocationRelativeTo(null); // Center window
        setLayout(null);            // Absolute layout
        setVisible(true);           // Make visible
    }

    // ======= Handle button actions =======
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == searchB) {
            // Search logic: find and show employee by ID
            String selectedId = choiceEMP.getSelectedItem();

            try {
                EmployeeDao dao = new EmployeeDao();
                EmployeeEntity emp = dao.getEmployeeById(selectedId);

                model.setRowCount(0); // Clear existing table rows

                if (emp != null) {
                    model.addRow(new Object[]{
                        emp.getEmpId(), emp.getName(), emp.getFname(), emp.getDob(),
                        emp.getSalary(), emp.getAddress(), emp.getPhone(), emp.getEmail(),
                        emp.getEducation(), emp.getDesignation(), emp.getAadhar()
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (ae.getSource() == print) {
            // Print the table
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            // Open update frame with selected employee ID
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());

        } else {
            // Back button pressed
            setVisible(false);
            new Home();
        }
    }
}

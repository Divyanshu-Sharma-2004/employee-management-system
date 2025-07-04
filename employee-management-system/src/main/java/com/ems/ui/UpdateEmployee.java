package com.ems.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import com.ems.dao.EmployeeDao;
import com.ems.model.EmployeeEntity;
import com.toedter.calendar.JDateChooser;

public class UpdateEmployee extends JFrame implements ActionListener {

    // Declare UI components (text fields, labels, buttons, etc.)
    JTextField tfname, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempid, tdob, taadhar, tname;
    JButton update, back;
    String empId;
    JComboBox Boxeducation;

    // Constructor to initialize the UpdateEmployee frame
    UpdateEmployee(String empId) {
        this.empId = empId;

        // Border for input fields
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Fonts for various components
        Font lfont = new Font("SAN_SERIF", Font.BOLD, 20);   // Label font
        Font font = new Font("Raleway", Font.BOLD, 18);      // Display text font
        Font tfont = new Font("Tahoma", Font.BOLD, 12);      // TextField font

        // Set frame background color
        getContentPane().setBackground(new Color(173, 216, 230));

        // Heading label
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // ====== Name Label and Value ======
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(lfont);
        add(name);

        tname = new JLabel();  // Display employee name
        tname.setBounds(200, 150, 150, 30);
        tname.setFont(font);
        add(tname);

        // ====== Father's Name ======
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(lfont);
        add(fname);

        tfname = new JTextField();  // Input for father's name
        tfname.setBounds(600, 150, 150, 30);
        tfname.setFont(tfont);
        tfname.setBorder(border);
        add(tfname);

        // ====== Date of Birth ======
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(lfont);
        add(dob);

        tdob = new JLabel();  // Display date of birth (not editable)
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(font);
        add(tdob);

        // ====== Salary ======
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(lfont);
        add(salary);

        tsalary = new JTextField();  // Input for salary
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setFont(tfont);
        tsalary.setBorder(border);
        add(tsalary);

        // ====== Address ======
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(lfont);
        add(address);

        taddress = new JTextField();  // Input for address
        taddress.setBounds(200, 250, 150, 30);
        taddress.setFont(tfont);
        taddress.setBorder(border);
        add(taddress);

        // ====== Phone ======
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(lfont);
        add(phone);

        tphone = new JTextField();  // Input for phone number
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBorder(border);
        tphone.setFont(tfont);
        add(tphone);

        // ====== Email ======
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(lfont);
        add(email);

        temail = new JTextField();  // Input for email
        temail.setBounds(200, 300, 150, 30);
        temail.setFont(tfont);
        temail.setBorder(border);
        add(temail);

        // ====== Education Dropdown ======
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 200, 30);
        education.setFont(lfont);
        add(education);

        String items[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);  // Education options
        Boxeducation.setFont(tfont);
        Boxeducation.setBorder(border);
        Boxeducation.setBounds(600, 300, 150, 30);
        add(Boxeducation);

        // ====== Aadhar (Non-editable) ======
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(lfont);
        add(aadhar);

        taadhar = new JLabel();  // Display aadhar (not editable)
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setFont(font);
        add(taadhar);

        // ====== Employee ID (Non-editable) ======
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(lfont);
        add(empid);

        tempid = new JLabel();  // Display employee ID
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // ====== Designation ======
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(lfont);
        add(designation);

        tdesignation = new JTextField();  // Input for designation
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBorder(border);
        tdesignation.setFont(tfont);
        add(tdesignation);

        // ====== Fetch Employee Data using Hibernate DAO ======
        try {
            EmployeeDao dao = new EmployeeDao();
            EmployeeEntity emp = dao.getEmployeeById(empId); // Get employee by ID

            if (emp != null) {
                // Populate form with existing data
                tname.setText(emp.getName());
                tfname.setText(emp.getFname());
                tdob.setText(emp.getDob().toString());
                tsalary.setText(emp.getSalary());
                taddress.setText(emp.getAddress());
                tphone.setText(emp.getPhone());
                temail.setText(emp.getEmail());
                Boxeducation.setSelectedItem(emp.getEducation());
                taadhar.setText(emp.getAadhar());
                tempid.setText(emp.getEmpId());
                tdesignation.setText(emp.getDesignation());
            } else {
                JOptionPane.showMessageDialog(null, "Unable to find Employee details");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ====== Update Button ======
        update = new JButton("UPDATE");
        update.setBounds(450, 550, 150, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBorder(border);
        update.addActionListener(this);
        add(update);

        // ====== Back Button ======
        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(border);
        back.addActionListener(this);
        add(back);

        // ====== Final Frame Settings ======
        setSize(900, 650);
        setLayout(null);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    // ====== ActionListener: Button Events ======
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {

            // ==== Field Validation ====
            if (
                tfname.getText().trim().isEmpty() ||
                tsalary.getText().trim().isEmpty() ||
                taddress.getText().trim().isEmpty() ||
                tphone.getText().trim().isEmpty() ||
                temail.getText().trim().isEmpty() ||
                tdesignation.getText().trim().isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Please fill all the details", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (tphone.getText().trim().length() != 10) {
                if (tphone.getText().trim().length() > 10) {
                    JOptionPane.showMessageDialog(null, "Phone number can't be more than 10 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Phone number must be exactly 10 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }

            try {
                // Create new entity and set updated data
                EmployeeEntity emp = new EmployeeEntity();
                emp.setName(tname.getText());
                emp.setEmpId(tempid.getText());
                emp.setFname(tfname.getText());
                emp.setDob(java.sql.Date.valueOf(tdob.getText()));
                emp.setSalary(tsalary.getText());
                emp.setAddress(taddress.getText());
                emp.setPhone(tphone.getText());
                emp.setEmail(temail.getText());
                emp.setEducation((String) Boxeducation.getSelectedItem());
                emp.setAadhar(taadhar.getText());
                emp.setDesignation(tdesignation.getText());

                // Update record using DAO
                EmployeeDao dao = new EmployeeDao();
                boolean success = dao.updateEmployee(emp);

                // Show confirmation or failure message
                if (success) {
                    JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
                    setVisible(false);
                    new ViewEmployee();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update employee");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while updating");
            }

        } else {
            // Back button clicked
            setVisible(false);
            new ViewEmployee();
        }
    }
}

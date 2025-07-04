package com.ems.ui; // Package declaration

// Required imports
import com.ems.dao.EmployeeDao;
import com.ems.model.EmployeeEntity;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Main class for adding employee details
public class AddEmployee extends JFrame implements ActionListener {

    // Randomly generate Employee ID
    Random ran = new Random();
    int number = ran.nextInt(999999); // random number between 0–999999

    // Form fields
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid; // To show auto-generated Employee ID
    JDateChooser tdob; // For selecting DOB using a calendar
    JButton add, back; // Buttons
    JComboBox Boxeducation; // Dropdown for education

    // Constructor for building the UI
    AddEmployee() {
        getContentPane().setBackground(new Color(255, 248, 240)); // Set background color

        // Border for fields
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Fonts
        Font lfont = new Font("SAN_SERIF", Font.BOLD, 20);
        Font tfont = new Font("Tahoma", Font.BOLD, 12);

        // Heading label
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // All labels and fields with bounds, font, and border setup
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(lfont);
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setFont(tfont);
        tname.setBorder(border);
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(lfont);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setFont(tfont);
        tfname.setBorder(border);
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(lfont);
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(tfont);
        tdob.setBorder(border);
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(lfont);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setFont(tfont);
        tsalary.setBorder(border);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(lfont);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setFont(tfont);
        taddress.setBorder(border);
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(lfont);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setFont(tfont);
        tphone.setBorder(border);
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(lfont);
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setFont(tfont);
        temail.setBorder(border);
        add(temail);

        JLabel education = new JLabel("Higest Education");
        education.setBounds(400, 300, 200, 30);
        education.setFont(lfont);
        add(education);

        String items[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBounds(600, 300, 150, 30);
        Boxeducation.setFont(tfont);
        Boxeducation.setBorder(border);
        add(Boxeducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(lfont);
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setFont(tfont);
        taadhar.setBorder(border);
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(lfont);
        add(empid);

        tempid = new JLabel("" + number); // Display generated ID
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(lfont);
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(lfont);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setFont(tfont);
        tdesignation.setBorder(border);
        add(tdesignation);

        // Add button
        add = new JButton("ADD");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Roboto", Font.BOLD, 14));
        add.setToolTipText("Click to Add Employee");
        add.setBorder(border);
        add.addActionListener(this);
        add(add);

        // Back button
        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Roboto", Font.BOLD, 14));
        back.setBorder(border);
        back.addActionListener(this);
        add(back);

        // Frame setup
        setSize(900, 650); // Size of frame
        setLayout(null); // No layout manager used (absolute positioning)
        setLocationRelativeTo(null); // Center on screen
        setVisible(true); // Make frame visible
    }

    // Event handling
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {

            // Basic validation
            if (
                tname.getText().trim().isEmpty() ||
                tfname.getText().trim().isEmpty() ||
                tdob.getDate() == null ||
                tsalary.getText().trim().isEmpty() ||
                taddress.getText().trim().isEmpty() ||
                tphone.getText().trim().isEmpty() ||
                temail.getText().trim().isEmpty() ||
                tdesignation.getText().trim().isEmpty() ||
                taadhar.getText().trim().isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Please fill all the details", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Phone validation
            if (tphone.getText().trim().length() != 10) {
                if (tphone.getText().trim().length() > 10) {
                    JOptionPane.showMessageDialog(null, "Phone number can't be more than 10 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Phone number must be exactly 10 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }

            // Aadhaar validation
            if (taadhar.getText().trim().length() != 12) {
                if (taadhar.getText().trim().length() > 12) {
                    JOptionPane.showMessageDialog(null, "Aadhaar number can't be more than 12 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Aadhaar number must be exactly 12 digits.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }

            // Populate entity with form data
            EmployeeEntity emp = new EmployeeEntity();
            emp.setEmpId(tempid.getText());
            emp.setName(tname.getText());
            emp.setFname(tfname.getText());
            emp.setDob(tdob.getDate());
            emp.setSalary(tsalary.getText());
            emp.setAddress(taddress.getText());
            emp.setPhone(tphone.getText());
            emp.setEmail(temail.getText());
            emp.setEducation((String) Boxeducation.getSelectedItem());
            emp.setDesignation(tdesignation.getText());
            emp.setAadhar(taadhar.getText());

            // Save employee to DB
            EmployeeDao dao = new EmployeeDao();
            boolean success = dao.saveEmployee(emp);

            // Show result message
            if (success) {
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
                new Home(); // Go to Home screen
            } else {
                JOptionPane.showMessageDialog(null, "Something went wrong");
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home(); // Go back to home screen
        }
    }
}

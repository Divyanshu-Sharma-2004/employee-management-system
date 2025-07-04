package com.ems.model;

import jakarta.persistence.*;
import java.util.Date;

/**
 * EmployeeEntity is a model class mapped to the "employee" table in the database.
 * It represents an Employee record and is managed by Hibernate ORM.
 */
@Entity  // Specifies that this class is an entity and is mapped to a database table
@Table(name = "employee") // Maps this entity to the "employee" table
public class EmployeeEntity {

    @Id // Marks empId as the primary key of the table
    private String empId;

    // Basic employee fields (will be automatically mapped to columns)
    private String name;
    private String fname;

    @Temporal(TemporalType.DATE) // Specifies that only the date part (not time) should be stored
    private Date dob;

    private String salary;
    private String address;
    private String phone;
    private String email;
    private String education;
    private String designation;
    private String aadhar;

    // Default constructor (required by Hibernate)
    public EmployeeEntity() {
        super();
    }

    /**
     * Parameterized constructor to initialize all fields
     */
    public EmployeeEntity(String empId, String name, String fname, Date dob, String salary,
                          String address, String phone, String email,
                          String education, String designation, String aadhar) {
        super();
        this.empId = empId;
        this.name = name;
        this.fname = fname;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.designation = designation;
        this.aadhar = aadhar;
    }

    // Getter and Setter methods for all fields
    // Used by Hibernate for persistence and by application to read/write data

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

}

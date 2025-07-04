package com.ems.model;

import jakarta.persistence.*;

/**
 * LoginEntity is a JPA entity class that maps to the "login" table in the database.
 * It holds login credentials (username and password) used for authentication.
 */
@Entity // Marks this class as a Hibernate Entity (mapped to a table)
@Table(name = "login") // Maps the class to the "login" table in the database
public class LoginEntity {

    @Id // Specifies that 'username' is the primary key for this table
    @Column(name = "username") // Maps this field to the 'username' column
    private String username;

    @Column(name = "password") // Maps this field to the 'password' column
    private String password;

    /**
     * Default constructor required by JPA/Hibernate
     */
    public LoginEntity() {}

    /**
     * Parameterized constructor to initialize both fields
     * @param username - unique user ID
     * @param password - associated password
     */
    public LoginEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}

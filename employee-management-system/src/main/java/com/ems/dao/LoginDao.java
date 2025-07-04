package com.ems.dao;

import com.ems.model.LoginEntity;
import com.ems.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * LoginDao handles login authentication logic using Hibernate.
 */
public class LoginDao {

    /**
     * Validates a user by checking if the provided username and password match a record in the database.
     *
     * @param username The username to validate
     * @param password The password to validate
     * @return true if a matching record exists; false otherwise
     */
    public boolean validateUser(String username, String password) {

        // Open a Hibernate session using SessionFactory
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // HQL query to check for matching username and password
            String hql = "FROM LoginEntity WHERE username = :uname AND password = :pwd";

            // Create a typed query and set parameters
            Query<LoginEntity> query = session.createQuery(hql, LoginEntity.class);
            query.setParameter("uname", username.trim()); // Trim to remove whitespace
            query.setParameter("pwd", password.trim());

            // Execute the query and check if a matching record is found
            return query.uniqueResult() != null;

        } catch (Exception e) {
            e.printStackTrace(); // Print error stack trace for debugging
            return false;         // Return false in case of exception
        }
    }
}

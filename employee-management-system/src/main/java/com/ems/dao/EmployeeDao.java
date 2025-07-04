package com.ems.dao;

import com.ems.model.EmployeeEntity;
import com.ems.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * EmployeeDao provides methods to perform CRUD operations on EmployeeEntity using Hibernate.
 */
public class EmployeeDao {

    /**
     * Save a new employee to the database.
     */
    public boolean saveEmployee(EmployeeEntity emp) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction(); // Begin transaction
            session.save(emp);               // Save employee entity
            tx.commit();                     // Commit transaction
            return true;                     // Return success
        } catch (Exception e) {
            if (tx != null) tx.rollback();   // Rollback if exception
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get a list of all employee IDs.
     */
    public List<String> getAllEmployeeIds() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT empId FROM EmployeeEntity";        // HQL to fetch only empId
            Query<String> query = session.createQuery(hql, String.class); // Create typed query
            return query.list();  // Return list of employee IDs
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get a list of all employee entities.
     */
    public List<EmployeeEntity> getAllEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM EmployeeEntity", EmployeeEntity.class).list();
            // HQL to fetch all records from EmployeeEntity
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Fetch a single employee by empId (Primary Key).
     */
    public EmployeeEntity getEmployeeById(String empId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(EmployeeEntity.class, empId); // Fetch by primary key
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update existing employee information.
     */
    public boolean updateEmployee(EmployeeEntity emp) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();  // Start transaction
            session.update(emp);              // Update record
            tx.commit();                      // Commit transaction
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();    // Rollback on error
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete an employee by empId.
     */
    public boolean deleteEmployee(String empId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();               // Start transaction

            EmployeeEntity emp = session.get(EmployeeEntity.class, empId); // Fetch entity by ID
            if (emp != null) {
                session.delete(emp);          // Delete the entity
                transaction.commit();         // Commit deletion
                return true;
            } else {
                return false; // Employee not found
            }

        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback on exception
            e.printStackTrace();
            return false;
        }
    }

}

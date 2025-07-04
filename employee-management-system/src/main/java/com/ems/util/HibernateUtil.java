package com.ems.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class for managing the SessionFactory object.
 * This class ensures that only one instance of SessionFactory is created (Singleton Pattern).
 */
public class HibernateUtil {

    // Static final reference to SessionFactory (created only once)
    private static final SessionFactory sessionFactory;

    // Static block executes once when the class is loaded
    static {
        try {
            // Create SessionFactory using the default hibernate.cfg.xml configuration
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // If SessionFactory creation fails, throw a runtime exception
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    /**
     * Public static method to get the SessionFactory instance.
     * Used throughout the application to get database sessions.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

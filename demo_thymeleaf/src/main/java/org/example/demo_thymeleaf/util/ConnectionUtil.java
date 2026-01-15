package org.example.demo_thymeleaf.util;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class ConnectionUtil {
    public static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}

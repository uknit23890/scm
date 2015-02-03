package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class to get hibernate objects to perform queries
 * @author Vinay Singh Rawat
 *
 */
public class HibernateUtil {  
    private static final SessionFactory sessionFactory;  
    static {  
        try {  
            sessionFactory = new Configuration().configure()  
                    .buildSessionFactory();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
 
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
}
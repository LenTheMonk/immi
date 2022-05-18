/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.tutorial;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Lukas
 */
public class HibernateUtils {
    
    private static final SessionFactory factorySingleton = HibernateUtils.createSingletonInstance();
    private static final String DB_NAME = "";
    
    public static SessionFactory getFactorySingleton() {
        return HibernateUtils.factorySingleton;
    }
    
    public static Session getNewSession() {
        return HibernateUtils.factorySingleton.openSession();
    }
    
    private static SessionFactory createSingletonInstance() {
        return new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" 
                        + HibernateUtils.DB_NAME + "?zeroDateTimeBehavior=convertToNull")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("show_sql", "true")
                .setProperty("format_sql", "true")
                .setProperty("use_sql_comments", "true")
                .buildSessionFactory();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.utils;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Lukas
 */
public class HibernateUtils {
    
    private static final SessionFactory factorySingleton = HibernateUtils.createSingletonInstance();
    private static final String DB_NAME = "jahresprojekt";
    private static Session openSession = null;
    
    public static SessionFactory getFactorySingleton() {
        return HibernateUtils.factorySingleton;
    }
    
    /**
     * Liefert stets eine neue Session.
     * @return Neue Session
     */
    private static Session getNewSession() {
        return HibernateUtils.factorySingleton.openSession();
    }
    
    /**
     * Liefert die offene Session. Falls keine Session existiert, wird sie neu
     * angelegt.
     * @return Session
     */
    public static Session getOpenSession() {
        if (openSession == null || !openSession.isOpen()) {
            openSession = HibernateUtils.getNewSession();
        }
        return openSession;
    }
    
    /**
     * Liefert eine neue SessionFactory, die mit der hibernate.cfg.xml
     * konfiguriert ist.
     * @return SessionFactory Singleton
     */
    private static SessionFactory createSingletonInstance() {
        File cfgFile = new File("src/hibernate.cfg.xml");
        return new Configuration()
                .configure(cfgFile)
                .buildSessionFactory();
    }
    
    // Alter Kram aus einer Übungsaufgabe. Erstmal so lassen.
    @Deprecated
    private static SessionFactory createLegacySingletonInstance() {
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

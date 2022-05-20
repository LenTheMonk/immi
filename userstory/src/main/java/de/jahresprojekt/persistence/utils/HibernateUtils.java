/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.utils;

import java.io.File;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Utilities für Hibernate.
 * @author Lukas
 */
public abstract class HibernateUtils {
    
    private static final SessionFactory factorySingleton = HibernateUtils.createSingletonInstance();
    private static final String DB_NAME = "jahresprojekt";
    private static Session openSession = null;
    private static EntityManager openManager = null;
    
    private static final String DIR_HIBERNATEUTILS = "\\desktop\\hibernate.cfg.xml";

    private HibernateUtils() {
    }
    
    /**
     * Liefert das SessionFactory Singleton.
     * @return SessionFactory
     */
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
        
        String userDir = System.getProperty("user.home");
        userDir = userDir.concat(HibernateUtils.DIR_HIBERNATEUTILS);
        System.out.println("User : " + userDir);
        File cfgFile = new File(userDir);
        System.out.println(cfgFile.getAbsolutePath());

        return new Configuration()
                .configure(cfgFile)
                .buildSessionFactory();
    }
    
    /**
     * Liefert einen aktuellen EntityManager.
     * @return EntityManager
     */
    public static EntityManager getCurrentEntityManager() {
        if (openManager == null || !openManager.isOpen()) {
           openManager = getOpenSession().getEntityManagerFactory()
                   .createEntityManager();
        }
        return openManager;
    }
    
    /**
     * Zerstört Session und EntityManager.
     */
    public static void shutdownAndCleanup() {
        openManager.close();
        openSession.getEntityManagerFactory().close();
        openSession.close();
        openManager = null;
        openSession = null;
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

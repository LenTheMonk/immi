/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence;

import de.jahresprojekt.datenbank.HibernateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lukas
 */
public class Steuer {
    
    
    public static void main(String[] args) {
        Steuer steuer = new Steuer();
        steuer.addOrt(212, "Kackhausen");
    }
    
    public OrtPojo addOrt(int plz, String name) {
        
        Session session = HibernateUtils.getNewSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            OrtPojo ort = new OrtPojo(name, plz);
            long id = (long) session.save(ort);
            System.out.println("id von ort " + id);
            tx.commit();
            return ort;
        } catch (Exception e) {
            if(tx!=null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        
        return null;
    }
}

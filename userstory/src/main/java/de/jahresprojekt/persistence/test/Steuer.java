/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.test;

import de.jahresprojekt.persistence.utils.HibernateUtils;
import de.jahresprojekt.persistence.dao.OrtDao;
import de.jahresprojekt.persistence.entities.Ort;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
* @author Lukas Eckert
 */
public class Steuer {
    
    
    public static void main(String[] args) {
        OrtDao dao = new OrtDao();
        Ort ort = new Ort("Krefeld", 47800);
        dao.save(ort);
        Ort ort2 = new Ort("Düsseldorf", 43351);
        dao.save(ort2);
        ort.setName("Crefeld");
        dao.save(ort);
        Ort ort3 = new Ort("Crefeld", 47800);
        dao.save(ort3);
        
    }
    
    public Ort addOrt(int plz, String name) {
        
        Session session = HibernateUtils.getNewSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Ort ort = new Ort(name, plz);
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
    
    public Ort getOrtByID(long iD) {
        Session session = HibernateUtils.getNewSession();
        Transaction tx = null;
        
        Ort loaded = null;
        
        try {
            tx = session.beginTransaction();
            
            loaded = session.get(Ort.class, iD);

            System.out.println("geladener ort " + loaded.getName() + " " + loaded.getPlz());
            tx.commit();
        } catch (Exception e) {
            if(tx!=null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        
        return loaded;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.test;

import de.jahresprojekt.persistence.utils.HibernateUtils;
import de.jahresprojekt.persistence.dao.OrtDao;
import de.jahresprojekt.persistence.entities.Ort;
import de.jahresprojekt.persistence.service.OrtRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
* @author Lukas Eckert
 */
public class SteuerungTest {
    
    /**
     * Main zum Testen
     * @param args 
     */
    public static void main(String[] args) {
        
        EntityManager manager = HibernateUtils.getOpenSession()
            .getEntityManagerFactory().createEntityManager();
        
        OrtRepository ortRep = new OrtRepository();
        
        List<Ort> orte = ortRep.findAll();
        
        System.out.println("de.jahresprojekt.persistence.test.SteuerungTest.main()");
//        Transaction tx = HibernateUtils.getOpenSession().beginTransaction();
//        OrtDao dao = new OrtDao();
//        Ort ort = new Ort("Krefeld", 47800);
//        dao.save(ort, tx);
//        Ort ort2 = new Ort("Düsseldorf", 43351);
//        dao.save(ort2, tx);
//        ort.setName("Crefeld");
//        dao.save(ort, tx);
//        Ort ort3 = new Ort("Crefeld", 47800);
//        dao.save(ort3, tx);
//        
    }
    
}

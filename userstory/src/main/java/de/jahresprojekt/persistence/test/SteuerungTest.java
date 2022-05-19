/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.test;

import de.jahresprojekt.persistence.utils.HibernateUtils;
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
        
        ortRep.delete(orte.get(1));
        
        orte = ortRep.findAll();
        
        orte.get(0).setName("Krähenfeld");
        orte.add(new Ort("Tschüsseldorf", 2293));
        ortRep.save(orte);
        
        System.out.println("de.jahresprojekt.persistence.test.SteuerungTest.main()");
        
    }
    
}

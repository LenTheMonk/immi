/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.test;

import de.jahresprojekt.logic.util.HashUtils;
import de.jahresprojekt.persistence.entities.impl.Nutzer;
import de.jahresprojekt.persistence.utils.HibernateUtils;
import de.jahresprojekt.persistence.entities.impl.Ort;
import de.jahresprojekt.persistence.repositories.impl.NutzerRepository;
import de.jahresprojekt.persistence.repositories.impl.OrtRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.datatable.DataTable;

/**
 * Testklasse
 * @author Lukas Eckert
 */
public class SteuerungTest {
    
    /**
     * Main zum Testen
     * @param args 
     */
    public static void main(String[] args) {
        

//        NutzerRepository rep = new NutzerRepository();
//        
//        rep.save(new Nutzer("Owner", HashUtils.getHash("noctis"), Boolean.TRUE,
//                "Lukas", "Eckert", "eckert@web.de",
//                "12345 667788", "0815 87654321"));
//        
//        System.out.println("de.jahresprojekt.persistence.test.SteuerungTest.main()");
        
        DataTable ds = new DataTable();
        for (String d : ds.getEventNames()) {
            System.out.println(d);
        }
    }
}

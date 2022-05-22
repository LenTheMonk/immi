/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.test;

import de.jahresprojekt.logic.util.HashUtils;
import de.jahresprojekt.persistence.entities.impl.Mieter;
import de.jahresprojekt.persistence.entities.impl.Mietobjekt;
import de.jahresprojekt.persistence.entities.impl.Nutzer;
import de.jahresprojekt.persistence.utils.HibernateUtils;
import de.jahresprojekt.persistence.entities.impl.Ort;
import de.jahresprojekt.persistence.repositories.impl.MieterRepository;
import de.jahresprojekt.persistence.repositories.impl.MietobjektRepository;
import de.jahresprojekt.persistence.repositories.impl.NutzerRepository;
import de.jahresprojekt.persistence.repositories.impl.OrtRepository;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.celleditor.CellEditor;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.roweditor.RowEditor;
import org.primefaces.component.selectmanymenu.SelectManyMenu;

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
        
//        MieterRepository mr = new MieterRepository();

//        NutzerRepository rep = new NutzerRepository();
//        
//        rep.save(new Nutzer("Owner", HashUtils.getHash("noctis"), Boolean.TRUE,
//                "Lukas", "Eckert", "eckert@web.de",
//                "12345 667788", "0815 87654321"));
//        
//        System.out.println("de.jahresprojekt.persistence.test.SteuerungTest.main()");
        
//        MieterRepository mr = new MieterRepository();
//        mr.save(new Mieter("Herr", "Max", "Mustermann", "Musterstrasse", "22039",
//                "Musterstadt", "mustermail@mail.de", "01152 776650", "0171 828294893",
//                "IBAN-2292922", "BIC-33383", "Max Mustermann", "Musterbank AG"));
//        mr.save(new Mieter("Frau", "Meike", "Musterfrau", "Musterstrasse", "22039",
//            "Musterstadt", "madamme_mustermail@mail.de", "01152 123455", "0171 28288989",
//            "IBAN-1234333", "BIC-75422", "Meike Musterfrau", "Musterbank AG"));

//        MietobjektRepository mor = new MietobjektRepository();
//        
//        mor.save(new Mietobjekt("Wohnung 1", "Wohnstrasse", "67890", "Mummelhausen",
//                20, 23.03, 12.92, false, false,
//                new Timestamp(2022, 4, 23, 0, 0, 0, 0),
//                new Timestamp(2023, 1, 1, 0, 0, 0, 0)));


        RowEditor men = new RowEditor();
//        System.out.println("Roweditor Events");
//        for (String d : men.getEventNames()) {
//            System.out.println(d);
//        }
        
        CellEditor ds = new CellEditor();
        System.out.println("Celleditor Events");
        for (String d : ds.getEventNames()) {
            System.out.println(d);
        }
    }
}

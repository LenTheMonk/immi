/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory;

import java.time.LocalDate;
import java.time.Month;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Lukas
 */
@Named(value = "druckerBean")
@SessionScoped
public class DruckerBean extends GenericBeanOld<Drucker>{

    public DruckerBean() {
        this.getObjectList().add(new Drucker("Farbtintenstrahldrucker", true, "A3",
                "S24", "DruckMatix", "Drucker LTD", "defekt", 21,
                LocalDate.of(2020, Month.APRIL, 12)));
        this.getObjectList().add(new Drucker("Farbtintenstrahldrucker", false, "A4",
                "DD01", "DruckerDream", "Druck GmbH", "OK", 21,
                LocalDate.of(2020, Month.APRIL, 12)));
        this.getObjectList().add(new Drucker("Laserdrucker", true, "A4",
                "S883", "DruckMatix", "Drucker LTD", "in Reparatur", 21,
                LocalDate.of(2020, Month.APRIL, 12)));
    }
    
    @Override
    public void resetObject() {
        this.setObject(new Drucker());
    }
    
    public void showRaum(){
        for (Drucker d : this.getObjectList()) {
            if(d.hasRaum()){
                System.out.println(d.getRaum().getBezeichnung());
                
            }
        }
    }
    
}

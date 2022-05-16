/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory.old;

import de.deuka.eckert.userstory.Drucker;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Lukas
 */
@Named(value="druckerBeanOld")
@SessionScoped
public class DruckerBeanOld implements Serializable{

    // Konstruktor
    public DruckerBeanOld() {
        druckerList = new ArrayList<>();
        
        druckerList.add(new Drucker("Farbtintenstrahldrucker", true, "A3",
                "S24", "DruckMatix", "Drucker LTD", "defekt", 21,
                LocalDate.of(2020, Month.APRIL, 12)));
        druckerList.add(new Drucker("Farbtintenstrahldrucker", false, "A4",
                "DD01", "DruckerDream", "Druck GmbH", "OK", 21,
                LocalDate.of(2020, Month.APRIL, 12)));
        druckerList.add(new Drucker("Laserdrucker", true, "A4",
                "S883", "DruckMatix", "Drucker LTD", "in Reparatur", 21,
                LocalDate.of(2020, Month.APRIL, 12)));
    }
    
    private Drucker drucker = new Drucker();
    
    private List<Drucker> druckerList;

    public Drucker getDrucker() { return this.drucker; }

    public void setDrucker(Drucker drucker) {
        this.drucker = drucker;
    }

    public List<Drucker> getDruckerList() { return this.druckerList; }

    public void setDruckerList(List<Drucker> druckerList) { this.druckerList = druckerList; }
    
    public void resetDrucker() { this.drucker = new Drucker(); }
    
  //-------------------------------------------------------------------------
  //  Method(s)
  //-------------------------------------------------------------------------     
    public void addDrucker()
    {
        if(this.druckerList.contains(drucker)){
            return;
        }
        this.druckerList.add(this.drucker);
        this.resetDrucker();
    }
    
    public void deleteDrucker(Drucker d) {
        this.druckerList.remove(d);
    }
    
    public void showRaum(){
        for (Drucker d : this.getDruckerList()) {
            if(d.hasRaum()){
                System.out.println(d.getRaum().getBezeichnung());
                
            }
        }
    }
}

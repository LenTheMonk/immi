/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory.old;

import de.deuka.eckert.userstory.Rechner;
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
@Named(value="rechnerBeanOld")
@SessionScoped
public class RechnerBeanOld implements Serializable{

    // Konstruktor
    public RechnerBeanOld() {
        rechnerList = new ArrayList<>();
        
        rechnerList.add(new Rechner("HP229", "HP Series 4", "HP", "OK",
                23, LocalDate.of(2010, Month.MAY, 22), "Intel i3", 4, "Windows XP",
                "Multimedia-PC", "Onboard Graphics", 250, 1000));
        rechnerList.add(new Rechner("L29", "Blue Variant", "Lenovo", "OK",
                2, LocalDate.of(2001, Month.MAY, 22), "Intel HD 1", 2, "Windows NT",
                "Gaming-PC", "Onboard Graphics", 0, 100));
        rechnerList.add(new Rechner("HP229", "HP Series 4", "HP", "OK",
                23, LocalDate.of(2010, Month.MAY, 22), "Intel i3", 4, "Windows XP",
                "Office-PC", "Onboard Graphics", 250, 1000));
    }
    
    private Rechner rechner = new Rechner();
    
    private List<Rechner> rechnerList;

    public Rechner getRechner() { return this.rechner; }

    public void setRechner(Rechner rechner) {
        this.rechner = rechner;
    }

    public List<Rechner> getRechnerList() { return this.rechnerList; }

    public void setRechnerList(List<Rechner> rechnerList) { this.rechnerList = rechnerList; }
    
    public void resetRechner() { this.rechner = new Rechner(); }
    
  //-------------------------------------------------------------------------
  //  Method(s)
  //-------------------------------------------------------------------------     
    public void addRechner()
    {
        if(this.rechnerList.contains(rechner)){
            return;
        }
        this.rechnerList.add(this.rechner);
        this.resetRechner();
    }
    
    public void deleteRechner(Rechner d) {
        this.rechnerList.remove(d);
    }
}

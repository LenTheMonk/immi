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
@Named(value="rechnerBean")
@SessionScoped
public class RechnerBean extends GenericBeanOld<Rechner>{

    public RechnerBean() {
        this.getObjectList().add(new Rechner("HP229", "HP Series 4", "HP", "OK",
                23, LocalDate.of(2010, Month.MAY, 22), "Intel i3", 4, "Windows XP",
                "Multimedia-PC", "Onboard Graphics", 250, 1000));
        this.getObjectList().add(new Rechner("L29", "Blue Variant", "Lenovo", "OK",
                2, LocalDate.of(2001, Month.MAY, 22), "Intel HD 1", 2, "Windows NT",
                "Gaming-PC", "Onboard Graphics", 0, 100));
        this.getObjectList().add(new Rechner("HP229", "HP Series 4", "HP", "OK",
                23, LocalDate.of(2010, Month.MAY, 22), "Intel i3", 4, "Windows XP",
                "Office-PC", "Onboard Graphics", 250, 1000));
    }
    
    @Override
    public void resetObject() {
        this.setObject(new Rechner());
    }
    
}

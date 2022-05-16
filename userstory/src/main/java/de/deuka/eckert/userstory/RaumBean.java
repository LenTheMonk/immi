/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Lukas
 */
@Named(value = "raumBean")
@SessionScoped
public class RaumBean extends GenericBeanOld<Raum>{

    public RaumBean() {
        this.getObjectList().add(new Raum("Großer Raum", "Raum"));
        this.getObjectList().add(new Raum("Kleiner Raum", "Raum"));
        this.getObjectList().add(new Raum("Mittlerer Raum", "Raum"));
    }
    
    @Override
    public void resetObject() {
        this.setObject(new Raum());
    }
    
}

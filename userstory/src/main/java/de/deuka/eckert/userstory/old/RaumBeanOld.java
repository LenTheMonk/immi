/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory.old;

import de.deuka.eckert.userstory.Raum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Lukas
 */
@Named(value="raumBeanOld")
@SessionScoped
public class RaumBeanOld implements Serializable{

    // Konstruktor
    public RaumBeanOld() {
        raumList = new ArrayList<>();
        
        raumList.add(new Raum("Großer Raum", "Raum"));
        raumList.add(new Raum("Kleiner Raum", "Raum"));
        raumList.add(new Raum("Mittlerer Raum", "Raum"));
    }
    
    private Raum raum = new Raum();
    
    private List<Raum> raumList;

    public Raum getRaum() { return this.raum; }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }

    public List<Raum> getRaumList() { return this.raumList; }

    public void setRaumList(List<Raum> raumList) { this.raumList = raumList; }
    
    public void resetRaum() { this.raum = new Raum(); }
    
  //-------------------------------------------------------------------------
  //  Method(s)
  //-------------------------------------------------------------------------     
    public void addRaum()
    {
        if(this.raumList.contains(raum)){
            return;
        }
        this.raumList.add(this.raum);
        this.resetRaum();
    }
    
    public void deleteRaum(Raum d) {
        this.raumList.remove(d);
    }
}

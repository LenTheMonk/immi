/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas
 */
public class Raum {
    
    private static int anzahl = 0;
    
    private int id;
    private String bezeichnung;
    private String typ;
    
    private List<Hardware> hardwareListe;

    public Raum() {
        anzahl++;
        this.id = anzahl;
    }
    
    public Raum(String bezeichnung, String typ) {
        this();
        this.bezeichnung = bezeichnung;
        this.typ = typ;
    }
    
    
    public void addHardware(Hardware hw){
        this.getHardwareListe().add(hw);
        System.out.println("Hardware " + hw.id + " Raum " + this.getBezeichnung());
        hw.setRaum(this);
    }
    
    public void removeHardware(Hardware hw){
        System.out.println("ENTFERNT");
        this.getHardwareListe().remove(hw);
        hw.setRaum(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public List<Hardware> getHardwareListe() {
        if (this.hardwareListe == null){
            this.hardwareListe = new ArrayList<>();
        }
        return this.hardwareListe;
    }

    public void setHardwareListe(List<Hardware> hardwareListe) {
        this.hardwareListe = hardwareListe;
    }
    
    public void scream(){
        System.out.println(this.hardwareListe.size());
    }
    
}

package de.jahresprojekt.datenbank.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
* @author Lukas Eckert
 */
public class Ort extends ModelTemp {
    private int postleitzahl;
    private String ortsname;
    
    public Ort(int plz, String name, long id) {
        super();
        this.postleitzahl = plz;
        this.ortsname = name;
    }
    
    public Ort() {
        super();
    }

    // Getter
    
    public String getOrtsname() {
        return ortsname;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }
    
    // Setter

    public void setOrtsname(String ortsname) {
        this.ortsname = ortsname;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.entities;

/**
 *
 * @author lukas
 */
public class Ort extends Datenbankobjekt{
    private int postleitzahl;
    private String ortsname;
    
    public Ort(int plz, String name, long id) {
        super(id);
        this.postleitzahl = plz;
        this.ortsname = name;
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

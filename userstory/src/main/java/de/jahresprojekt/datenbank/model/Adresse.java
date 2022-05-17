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
public class Adresse extends ModelTemp {
    private String strasse;
    private int hausnummer;
    private Ort ort;
    
    public Adresse(String strasse, int hnr, Ort ort) {
        super();
        this.hausnummer = hnr;
        this.strasse = strasse;
        this.ort = ort;
    }
    
    public Adresse() {
        super();
    }
    
    // Getter

    public int getHausnummer() {
        return hausnummer;
    }

    public String getStrasse() {
        return strasse;
    }

    public Ort getOrt() {
        return ort;
    }
    
    // Setter

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
}

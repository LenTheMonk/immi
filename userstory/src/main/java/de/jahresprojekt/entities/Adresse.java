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
public class Adresse extends Datenbankobjekt {
    private String strasse;
    private int hausnummer;
    private Ort ort;
    
    public Adresse(long id, String strasse, int hnr, Ort ort) {
        super(id);
        this.hausnummer = hnr;
        this.strasse = strasse;
        this.ort = ort;
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

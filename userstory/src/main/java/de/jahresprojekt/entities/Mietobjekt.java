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
public class Mietobjekt extends Datenbankobjekt{
    private int objektnummer;
    private String objekttyp;
    private String beschreibung;
    private Adresse adresse;
    private double wohnflaeche;
    private double quadratmeterpreis;
    private double nebenkosten;
    private String notiz;

    public Mietobjekt(long id, int onr, String typ, String desc, Adresse adr,
            double flaeche, double qm, double neben, String note) {
        super(id);
        this.objektnummer = onr;
        this.objekttyp = typ;
        this.beschreibung = desc;
        this.adresse = adr;
        this.wohnflaeche = flaeche;
        this.quadratmeterpreis = qm;
        this.nebenkosten = neben;
        this.notiz = note;
    }
    
    
}

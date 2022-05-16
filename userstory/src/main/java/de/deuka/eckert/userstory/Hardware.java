/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory;

import java.time.LocalDate;

/**
 *
 * @author Lukas
 */
public abstract class Hardware {
    
    protected static int anzahl;
    
    protected int id;
    protected String serienNummer;
    protected String modell;
    protected String hersteller;
    protected String status;
    protected int herstellergarantie;
    protected LocalDate lieferDatum;
    
    protected Raum raum = null;

    // Standardkonstruktor
    public Hardware() {
        Hardware.anzahl++;
        this.id = Hardware.anzahl;
    }

    public Hardware(String serienNummer, String modell, String hersteller, String status, int herstellergarantie, LocalDate lieferDatum) {
        this();
        this.serienNummer = serienNummer;
        this.modell = modell;
        this.hersteller = hersteller;
        this.status = status;
        this.herstellergarantie = herstellergarantie;
        this.lieferDatum = lieferDatum;
    }

    /**
     * Berechnet Garantieende.
     * @return Garantieende
     */
    public LocalDate berechneGarantieende() {
        return this.getLieferDatum().plusMonths(this.herstellergarantie);
    }

    
    public boolean hasRaum() {
        return raum != null;
    }
    
    // Getter und Setter
    
    public LocalDate getLieferDatum() {
        return lieferDatum;
    }

    public void setLieferDatum(LocalDate lieferDatum) {
        this.lieferDatum = lieferDatum;
    }
    
    public static int getAnzahl() {
        return anzahl;
    }

    public static void setAnzahl(int anzahl) {
        Hardware.anzahl = anzahl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerienNummer() {
        return serienNummer;
    }

    public void setSerienNummer(String serienNummer) {
        this.serienNummer = serienNummer;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHerstellergarantie() {
        return herstellergarantie;
    }

    public void setHerstellergarantie(int herstellergarantie) {
        this.herstellergarantie = herstellergarantie;
    }

    public Raum getRaum() {
        return this.raum;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }
    
}

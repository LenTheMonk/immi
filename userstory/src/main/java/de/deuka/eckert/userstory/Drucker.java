/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.deuka.eckert.userstory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lukas
 */
public class Drucker extends Hardware{

    private String technologie;
    private boolean farbdruckfunktion;
    private String papierformatmax;
    private int druckseitengesamt;
    private int restkapazitaet;
    private int kapazitaetbetriebsmittel;

    public Drucker() {
        super();
    }
    
    public Drucker(String technologie, boolean farbdruckfunktion, String papierformatmax, String serienNummer, String modell, String hersteller, String status, int herstellergarantie, LocalDate lieferDatum) {
        super(serienNummer, modell, hersteller, status, herstellergarantie, lieferDatum);
        this.technologie = technologie;
        this.farbdruckfunktion = farbdruckfunktion;
        this.papierformatmax = papierformatmax;
    }

    @Override
    public String toString() {
        return "Dies ist ein Drucker " + this.getDruckerBeschreibung();
    }

    public void wechsleBetriebsmittel(int kapazitaet) {
        
    }
    
    public void drucken(int seiten){
        if(seiten <= 0){
            //JOptionPane.showMessageDialog(null, "Keine Seiten zu drucken","Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(this.getRestkapazitaet() < seiten){
            int gedruckt = seiten - (seiten - this.getRestkapazitaet());
            this.setDruckseitengesamt(this.getDruckseitengesamt() + gedruckt);
            this.setRestkapazitaet(0);
            // JOptionPane.showMessageDialog(null, String.format("Es konnten %s von %s Seiten gedruckt werden."
            //        + " \n Bitte wechseln Sie das Betriebsmittel!", gedruckt, seiten), "Warnung", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.setDruckseitengesamt(this.getDruckseitengesamt() + seiten);
        this.setRestkapazitaet(this.getRestkapazitaet() - seiten);
        // JOptionPane.showMessageDialog(null, String.format("Es konnten %s Seiten gedruckt werden.", seiten), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    private String getDruckerBeschreibung(){
        
        List<String> werte = new ArrayList<>();
        werte.add(Integer.toString(this.getId()));
        werte.add(this.getSerienNummer());
        werte.add(this.getModell());
        werte.add(this.getHersteller());
        werte.add(Integer.toString(this.getHerstellergarantie()));
        werte.add(String.valueOf(this.getLieferDatum()));
        werte.add(this.getTechnologie());
        werte.add(Boolean.toString(this.isFarbdruckfunktion()));
        werte.add(this.getPapierformatmax());
        werte.add(Integer.toString(this.getDruckseitengesamt()));
        werte.add(Integer.toString(this.restkapazitaet));
        werte.add(Integer.toString(this.getKapazitaetbetriebsmittel()));
        
        String beschreibung = "";
        
        for(String aktuellerString : werte){
            beschreibung += aktuellerString;
            beschreibung += ";";
        }
        beschreibung = beschreibung.substring(0, beschreibung.length() - 1);
        
        return beschreibung;
    }
    
    
    // Getter und Setter

    public String getTechnologie() {
        return technologie;
    }

    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }

    public boolean isFarbdruckfunktion() {
        return farbdruckfunktion;
    }

    public void setFarbdruckfunktion(boolean farbdruckfunktion) {
        this.farbdruckfunktion = farbdruckfunktion;
    }

    public String getPapierformatmax() {
        return papierformatmax;
    }

    public void setPapierformatmax(String papierformatmax) {
        this.papierformatmax = papierformatmax;
    }

    public int getDruckseitengesamt() {
        return druckseitengesamt;
    }

    public void setDruckseitengesamt(int druckseitengesamt) {
        this.druckseitengesamt = druckseitengesamt;
    }

    public int getRestkapazitaet() {
        return restkapazitaet;
    }

    public void setRestkapazitaet(int restkapazitaet) {
        this.restkapazitaet = restkapazitaet;
    }

    public int getKapazitaetbetriebsmittel() {
        return kapazitaetbetriebsmittel;
    }

    public void setKapazitaetbetriebsmittel(int kapazitaetbetriebsmittel) {
        this.kapazitaetbetriebsmittel = kapazitaetbetriebsmittel;
    }
    
}

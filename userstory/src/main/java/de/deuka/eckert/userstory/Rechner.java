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
public class Rechner extends Hardware {

    private String cpu;
    private int arbeitsspeicher;
    private String betriebssystem;
    private String typ;
    private String grafikkarte;
    private int festplatte_ssd;
    private int festplatte_hdd;

    public Rechner() {
        super();
    }
    
    public Rechner(String serienNummer, String modell, String hersteller, String status, int herstellergarantie,
            LocalDate lieferDatum, String cpu, int arbeitsspeicher, String betriebssystem, String typ,
            String grafikkarte, int festplatte_ssd, int festplatte_hdd) {
        super(serienNummer, modell, hersteller, status, herstellergarantie, lieferDatum);
        
        this.cpu = cpu;
        this.arbeitsspeicher = arbeitsspeicher;
        this.betriebssystem = betriebssystem;
        this.typ = typ;
        this.grafikkarte = grafikkarte;
        this.festplatte_ssd = festplatte_ssd;
        this.festplatte_hdd = festplatte_hdd;
    }

    @Override
    public String toString() {
        return "Dies ist ein Rechner";
    }

    
    
    // Getter und Setter
    
    
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getArbeitsspeicher() {
        return arbeitsspeicher;
    }

    public void setArbeitsspeicher(int arbeitsspeicher) {
        this.arbeitsspeicher = arbeitsspeicher;
    }

    public String getBetriebssystem() {
        return betriebssystem;
    }

    public void setBetriebssystem(String betriebssystem) {
        this.betriebssystem = betriebssystem;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getGrafikkarte() {
        return grafikkarte;
    }

    public void setGrafikkarte(String grafikkarte) {
        this.grafikkarte = grafikkarte;
    }

    public int getFestplatte_ssd() {
        return festplatte_ssd;
    }

    public void setFestplatte_ssd(int festplatte_ssd) {
        this.festplatte_ssd = festplatte_ssd;
    }

    public int getFestplatte_hdd() {
        return festplatte_hdd;
    }

    public void setFestplatte_hdd(int festplatte_hdd) {
        this.festplatte_hdd = festplatte_hdd;
    }
 
    
    
}

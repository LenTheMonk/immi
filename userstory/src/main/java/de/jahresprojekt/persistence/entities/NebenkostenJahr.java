/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Lukas Eckert
 * @author Simon Stabbert
 */
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "NEBENKOSTENJAHR")
public class NebenkostenJahr {
	
    @Id
    @GeneratedValue
    @Column(name = "NEBENKOSTENJAHR_ID")
    private long id;
    
    @Column(nullable = false)
    private String bezeichnung;
    
    @Column(nullable = false)
    private double betrag;
    
    @Column(nullable = false)
    private Timestamp datum;
    
    @Column(nullable = false)
    private boolean istBezahlt;
   
    @OneToMany(mappedBy = "nebenkostenJahr", cascade = CascadeType.ALL)
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
    
    public NebenkostenJahr() {
    }
    
    public NebenkostenJahr(String aBezeichnung, double aBetrag, Timestamp aDatum, String aIstBezahlt) {
    	    	bezeichnung = aBezeichnung;
    	    	betrag = aBetrag;
    	    	datum = aDatum;
    	       	istBezahlt = aIstBezahlt;
    	    }
      
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public long setId(aId) {
    	id = aId; 
    }
    
    public String getBezeichnung() {
        return bezeichnung;
    }
     
    public String setBezeichnung(aBezeichnung) {
    	bezeichnung = aBezeichnung; 
    }
    
    public double getBetrag() {
        return betrag;
    }
    
    public double setBetrag(aBetrag) {
    	betrag = aBetrag; 
    }
    
    public Timestamp getDatum() {
        return datum;
    }
    
    public Timestamp setDatum(aDatum) {
    	datum = aDatum; 
    }
       
    public boolean getIstBezahlt() {
    	return istBezahlt; 
    }		
    
    public void setistBezahlt(String aIstBezahlt) {
       istBezahlt = aIstBezahlt;
    }
    
    public List<Mietobjekt> getMietobjekte() {
        return mietobjekte;
    }
    
    public void addMietobjekt(Mietobjekt aMietobjekt) {
        mietobjekte.add(aMietobjekt);
        mietobjekte.setNebenkostenJahr(this);
    }
    
  
}
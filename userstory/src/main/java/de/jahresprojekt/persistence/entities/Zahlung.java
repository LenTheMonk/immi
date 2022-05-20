/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

import de.jahresprojekt.persistence.entities.base.BaseEntity;
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
@Table(name = "ZAHLUNG")
public class Zahlung extends BaseEntity{
	
    @Id
    @GeneratedValue
    @Column(name = "ZAHLUNG_ID")
    private long id;
    
    @Column(nullable = false)
    private String bezeichnung;
    
    @Column(nullable = false)
    private double betrag;
    
    @Column(nullable = false)
    private Timestamp datum;
    
	@Column(nullable = false)
    private String iban;
    
    @Column(nullable = false)
    private String bic;
    
    @Column(nullable = false)
    private String Kontoinhaber;
    
    @Column(nullable = false)
    private String Kreditinstitut;
    
    @OneToMany(mappedBy = "zahlung", cascade = CascadeType.ALL)
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
    
    public Zahlung() {
    }
    
    public Zahlung(String aBezeichnung, double aBetrag, Timestamp aDatum, String aIban,  String aBic, 
    	    String aKontoinhaber, aKreditinstitut) {
    	    	bezeichnung = aBezeichnung;
    	    	betrag = aBetrag;
    	    	datum = aDatum;
    	       	iban = aIban;
    	        bic = aBic;
    	        kontoinhaber = aKontoinhaber;
    	        kreditinstitut = aKreditinstiut;
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
    
    public String getIban() {
        return iban;
    }
    
    public void setIban(String aIban) {
       iban = aIban;
    }   
    public String getBic() {
        return bic;
    }
    
    public void setBic(String aBic) {
       bic = aBic;
    }
       
    public String getKontoinhaber() {
        return kontoinhaber;
    }
    
    public void setKontinhaber(String aKontoinhaber) {
       kontoinhaber = aKontoinhaber;
    }
       
    public String getKreditinstitut() {
    	return kreditinstitut; 
    }		
    
    public void setKreditinstitut(String aKreditinstitut) {
       kreditinstitut = aKreditinstitut;
    }
    
    public List<Mietobjekt> getMietobjekte() {
        return mietobjekte;
    }
    
    public void addMietobjekt(Mietobjekt aMietobjekt) {
        mietobjekte.add(aMietobjekt);
        mietobjekte.setZahlung(this);
    }
    
  
}
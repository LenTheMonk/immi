/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities.impl;

/**
 * 
 * @author Lukas Eckert
 * @author Simon Stabbert
 */
import de.jahresprojekt.persistence.entities.impl.BaseEntity;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = Zahlung.TABLE_NAME)
public class Zahlung extends BaseEntity{
	
    public static final String TABLE_NAME = "ZAHLUNG";
	 
    @Id
    @GeneratedValue
    private long id;
    
    public static final String MAP_BEZEICHNUNG = "bezeichnung";
    @Column(nullable = false, name = Zahlung.MAP_BEZEICHNUNG)
    private String bezeichnung;
    
    public static final String MAP_BETRAG = "betrag";
    @Column(nullable = false, name = Zahlung.MAP_BETRAG)
    private double betrag;
    
    public static final String MAP_DATUM = "datum";
    @Column(nullable = false, name = Zahlung.MAP_DATUM)
    private Timestamp datum;
    
    @Column(nullable = false)
    private String iban;
    
    public static final String MAP_BIC = "bic";
    @Column(nullable = false, name = Zahlung.MAP_BIC)
    private String bic;
    
    public static final String MAP_KONTOINHABER = "kontoinhaber";
    @Column(nullable = false, name = Zahlung.MAP_KONTOINHABER)
    private String kontoinhaber;
    
    public static final String MAP_KREDITINSTITUT = "Kreditinstitut";
    @Column(nullable = false, name = Zahlung.MAP_KREDITINSTITUT)
    private String kreditinstitut;
    
    public static final String MAP_MIETOBJEKT = "mietobjekt";
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE,
        CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="MIETOBJEKT_ZAHLUNG")
    private Mietobjekt mietobjekt;
    
    public Zahlung() {
    }
    
    public Zahlung(String aBezeichnung, double aBetrag, Timestamp aDatum, String aIban,  String aBic, 
    	    String aKontoinhaber,String aKreditinstitut) {
    	    	bezeichnung = aBezeichnung;
    	    	betrag = aBetrag;
    	    	datum = aDatum;
    	       	iban = aIban;
    	        bic = aBic;
    	        kontoinhaber = aKontoinhaber;
    	        kreditinstitut = aKreditinstitut;
    	    }
      
    @Override
    public String getTableName() {
        return Zahlung.TABLE_NAME;
    }
    
    // Getter Setter
    
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public void setId(long aId) {
        id = aId; 
    }
    
    public String getBezeichnung() {
        return bezeichnung;
    }
     
    public void setBezeichnung(String aBezeichnung) {
    	bezeichnung = aBezeichnung; 
    }
    
    public double getBetrag() {
        return betrag;
    }
    
    public void setBetrag(double aBetrag) {
    	betrag = aBetrag; 
    }
    
    public Timestamp getDatum() {
        return datum;
    }
    
    public void setDatum(Timestamp aDatum) {
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
    
    public Mietobjekt getMietobjekt() {
        return mietobjekt;
    }

    public void setMietobjekt(Mietobjekt mietobjekt) {
        this.mietobjekt = mietobjekt;
    }
     
}
/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

/**
 * 
 * @author Lukas Eckert
 * @author Simon Stabbert
 */
import de.jahresprojekt.persistence.entities.base.BaseEntity;
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

@Entity
@Table(name = NebenkostenJahr.TABLE_NAME)
public class NebenkostenJahr extends BaseEntity{
	
    public static final String TABLE_NAME = "NEBENKOSTENJAHR";
    
    @Id
    @GeneratedValue
    private long id;
    
    public static final String MAP_BEZEICHNUNG = "bezeichnung";
    @Column(nullable = false, name = NebenkostenJahr.MAP_BEZEICHNUNG)
    private String bezeichnung;
    
    public static final String MAP_BETRAG = "betrag";
    @Column(nullable = false, name = NebenkostenJahr.MAP_BETRAG)
    private double betrag;
    
    public static final String MAP_DATUM = "datum";
    @Column(nullable = false, name = NebenkostenJahr.MAP_DATUM)
    private Timestamp datum;
    
    public static final String MAP_ISTBEZAHLT = "istBezahlt";
    @Column(nullable = false, name = NebenkostenJahr.MAP_ISTBEZAHLT)
    private boolean istBezahlt;
   
    @OneToMany(mappedBy = Mietobjekt.MAP_NEBENKOSTENJAHR,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.REFRESH, CascadeType.DETACH})
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
    
    public NebenkostenJahr() {
    }
    
    public NebenkostenJahr(String aBezeichnung, double aBetrag,
            Timestamp aDatum, boolean aIstBezahlt) {
    	    	bezeichnung = aBezeichnung;
    	    	betrag = aBetrag;
    	    	datum = aDatum;
    	       	istBezahlt = aIstBezahlt;
    	    }
      
    @Override
    public String getTableName() {
        return NebenkostenJahr.TABLE_NAME;
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
       
    public boolean getIstBezahlt() {
    	return istBezahlt; 
    }		
    
    public void setistBezahlt(boolean aIstBezahlt) {
       istBezahlt = aIstBezahlt;
    }
    
    public List<Mietobjekt> getMietobjekte() {
        return mietobjekte;
    }
    
    public void addMietobjekt(Mietobjekt aMietobjekt) {
        mietobjekte.add(aMietobjekt);
        aMietobjekt.setNebenkostenJahr(this);
    }
    
  
}
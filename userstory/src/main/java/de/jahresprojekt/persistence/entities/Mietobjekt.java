/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

import de.jahresprojekt.persistence.entities.base.BaseEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

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
@Table(name = "MIETOBJEKT")
public class Mietobjekt extends BaseEntity {
	
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String bezeichnung;
    
    @Column(nullable = false)
    private String strasse;
    
    @Column(nullable = false)
    private String plz;
    
    @Column(nullable = false)
    private String ort;
    
    @Column(nullable = false)
    private Integer qm; 
    
    @Column(nullable = false)
    private Double qmpreiskalt;
    
    @Column(nullable = false)
    private Double nebenkosten;
    
    @Column(nullable = false)
    private boolean istGewerblich;
    
    @Column(nullable = false)
    private boolean istVermietet;
    
    @Column(nullable = true)
    private Timestamp mietbeginn;
    
    @Column(nullable = true)
    private Timestamp mietende;
    
    @ManyToOne
    @JoinColumn(name="MIETER_ID")
    private Mieter mieter;
    
    @ManyToOne
    @JoinColumn(name="MIETKOMPLEX_ID")
    private Mietkomplex mietkomplex;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name=BaseEntity.MAP_ID)
    public static final String MAP_ANSPRECHPARTNER = "ansprechpartner";
    private Ansprechpartner ansprechpartner;
    
    @ManyToOne
    @JoinColumn(name="NEBENKOSTENJAHR_ID")
    private NebenkostenJahr nebenkostenJahr;
    
    @ManyToOne
    @JoinColumn(name="ZAHLUNGEN_ID")
    private Zahlung zahlung;
    
    public Mietobjekt() {
    }
    
    public Mietobjekt(Integer aId, String aBezeichnung, String aStrasse, String aPlz,
    	    String aOrt, Integer aQm, Double aQmpreiskalt, Double aNebenkosten, boolean aIstGewerblich, boolean aIstVermietet, 
    	    Timestamp aMietbeginn, Timestamp aMietende ) {
        id = aId;
        bezeichnung = aBezeichnung;
        strasse = aStrasse;
        plz = aPlz;
        ort = aOrt;
        qm = aQm;
        qmpreiskalt = aQmpreiskalt;
        nebenkosten = aNebenkosten;
        istGewerblich = aIstGewerblich;
        istVermietet = aIstVermietet;
        mietbeginn = aMietbeginn;
        mietende = aMietende;
    }

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
     
    public String setBezeichnung(String aBezeichnung) {
    	bezeichnung = aBezeichnung; 
    }
    
    public Integer getQm() {
        return qm;
    }
    
    public Integer setQm(Integer aQm) {
    	qm = aQm; 
    }  
    
    public Double getQmpreiskalt() {
        return qmpreiskalt;
    }
    
    public void setQmpreiskalt(Double aQmpreiskalt) {
    	qmpreiskalt = aQmpreiskalt; 
    }
    
    public Double getNebenkosten() {
        return nebenkosten;
    }
    
    public void setNebenkosten(Double aNebenkosten) {
    	nebenkosten = aNebenkosten; 
    }
    
    public boolean getIstGewerblich() {
        return istGewerblich;
    }
    
    public void setIstGewerblich(boolean aIstGewerblich) {
    	istGewerblich = aIstGewerblich; 
    }
    
    public boolean getIstVermietet() {
        return istVermietet;
    }
    
    public void setIstVermietet(boolean aIstVermietet) {
    	istVermietet = aIstVermietet; 
    }
    
    public Timestamp getMietbeginn() {
        return mietbeginn;
    }
    
    public Timestamp setMietbeginn(Timestamp aMietbeginn) {
    	mietbeginn = aMietbeginn; 
    }
    
    public Timestamp getMietende() {
        return mietende;
    }
    
    public Timestamp setMietende(Timestamp aMietende) {
    	mietende = aMietende; 
    }
    
    public Mieter getMieter() {
        return mieter;
    }
    
    public void setMieter(Mieter aMieter) {
        mieter = aMieter;
    }
    
    public Mietkomplex getMietkomplex() {
        return mietkomplex;
    }
    
    public void setMietkomplex(Mietkomplex aMietkomplex) {
        mietkomplex = aMietkomplex;
    }
    
    public Ansprechpartner getAnsprechpartner() {
        return ansprechpartner;
    }
    
    public void setAnsprechpartner(Ansprechpartner aAnsprechpartner) {
        ansprechpartner = aAnsprechpartner;
    }
    
    public NebenkostenJahr getNebenkostenJahr() {
        return nebenkostenJahr;
    }
    
    public void setNebenkostenJahr(NebenkostenJahr aNebenkostenJahr) {
    	nebenkostenJahr = aNebenkostenJahr;
    }
    
    public Zahlung getZahlung() {
        return zahlung;
    }
    
    public void setZahlung(Zahlung aZahlung) {
    	zahlung = aZahlung;
    }
}
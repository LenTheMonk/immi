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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = Mietobjekt.TABLE_NAME)
public class Mietobjekt extends BaseEntity {
	
    public static final String TABLE_NAME = "MIETOBJEKT";
	
    @Id
    @GeneratedValue
    private long id;
    
    public static final String MAP_BESCHREIBUNG = "beschreibung";
    @Column(nullable = false, name = Mietobjekt.MAP_BESCHREIBUNG)
    private String beschreibung;
    
    public static final String MAP_STRASSE = "strasse";
    @Column(nullable = true, name = Mietobjekt.MAP_STRASSE)
    private String strasse;
     
    public static final String MAP_PLZ = "plz";
    @Column(nullable = true, name = Mietobjekt.MAP_PLZ)
    private String plz;
    
    public static final String MAP_ORT= "ort";
    @Column(nullable = true, name = Mietobjekt.MAP_ORT)
    private String ort;
    
    public static final String MAP_QM = "qm";
    @Column(nullable = true, name = Mietobjekt.MAP_QM)
    private Integer qm; 
    
    public static final String MAP_QMPREISKALT = "qmpreiskalt";
    @Column(nullable = true, name = Mietobjekt.MAP_QMPREISKALT)
    private Double qmpreiskalt;
    
    public static final String MAP_NEBENKOSTEN = "nebenkosten";
    @Column(nullable = true, name = Mietobjekt.MAP_NEBENKOSTEN)
    private Double nebenkosten;
    
    public static final String MAP_ISTGEWERBLICH = "istGewerblich";
    @Column(nullable = false, name = Mietobjekt.MAP_ISTGEWERBLICH)
    private boolean istGewerblich;
    
    public static final String MAP_ISTVERMIETET = "istVermietet";
    @Column(nullable = false, name = Mietobjekt.MAP_ISTVERMIETET)
    private boolean istVermietet;
    
    public static final String MAP_MIETBEGINN = "mietbeginn";
    @Column(nullable = true, name = Mietobjekt.MAP_MIETBEGINN)
    private Timestamp mietbeginn;
    
    public static final String MAP_MIETENDE = "mietende";
    @Column(nullable = true, name = Mietobjekt.MAP_MIETENDE)
    private Timestamp mietende;
    
    public static final String MAP_MIETER = "mieter";
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE,
        CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}) 
    @JoinColumn(name="MIETER_MIETOBJEKT")
    private Mieter mieter;
    
    //TODO: WIRD HIER DURCH DETACH DER MIETKOMPLEX GELÖSCHT?
    public static final String MAP_MIETKOMPLEX = "mietkomplex";
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="MIETKOMPLEX_MIETOBJEKT")
    private Mietkomplex mietkomplex;
    
    public static final String MAP_ANSPRECHPARTNER = "ansprechpartner";
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE,
        CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}) 
    @JoinColumn(name="ANSPRECHPARTNER_MIETOBJEKT")
    private Ansprechpartner ansprechpartner;
    
    @OneToMany(mappedBy = NebenkostenJahr.MAP_MIETOBJEKT,
        fetch=FetchType.EAGER,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<NebenkostenJahr> nebenkostenjahr;
    
    @OneToMany(mappedBy = Zahlung.MAP_MIETOBJEKT,
        fetch=FetchType.EAGER,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Zahlung> zahlungen;
    
    
    public Mietobjekt() {
    }
    
    public Mietobjekt(String aBeschreibung, String aStrasse, String aPlz,
    	    String aOrt, Integer aQm, Double aQmpreiskalt, Double aNebenkosten,
            boolean aIstGewerblich, boolean aIstVermietet, 
    	    Timestamp aMietbeginn, Timestamp aMietende ) {
                beschreibung = aBeschreibung;
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
    public String getTableName() {
        return Ansprechpartner.TABLE_NAME;
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
    
    public Integer getQm() {
        return qm;
    }
    
    public void setQm(Integer aQm) {
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
    
    public void setMietbeginn(Timestamp aMietbeginn) {
    	mietbeginn = aMietbeginn; 
    }
    
    public Timestamp getMietende() {
        return mietende;
    }
    
    public void setMietende(Timestamp aMietende) {
    	mietende = aMietende; 
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
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
    
    public List<NebenkostenJahr> getNebenkostenjahr() {
        return nebenkostenjahr;
    }
    
    public void setNebenkostenjahr(List<NebenkostenJahr> aNebenkostenjahr) {
    	nebenkostenjahr = aNebenkostenjahr;
    }
    
    public List<Zahlung> getZahlungen() {
        return zahlungen;
    }
    
    public void setZahlungen(List<Zahlung> aZahlung) {
    	zahlungen = aZahlung;
    }
}
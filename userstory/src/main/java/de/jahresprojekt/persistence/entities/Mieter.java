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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "MIETER")
public class Mieter {
	
    @Id
    @GeneratedValue
    @Column(name="MIETER_ID")
    private long id;
    
    @Column(nullable = false)
    private String anrede;
    
    @Column(nullable = false)
    private String vorname;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String strasseAlt;
    
    @Column(nullable = false)
    private String plzAlt;
    
    @Column(nullable = false)
    private String ortAlt;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String festnetz;
       
    @Column(nullable = false)
    private String mobil;
    
	@Column(nullable = false)
    private String iban;
    
    @Column(nullable = false)
    private String bic;
    
    @Column(nullable = false)
    private String Kontoinhaber;
    
    @Column(nullable = false)
    private String Kreditinstitut;
   
    
    @OneToMany(mappedBy = "mieter", cascade = CascadeType.ALL)
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
    
    @OneToMany(mappedBy = "mieter", cascade = CascadeType.ALL)
    private List<Mietkomplex> mietkomplexe = new ArrayList<>();
    
    public Mieter() {
    }
    
    public Mieter(String aAnrede, String aVorname, String aName, String aStrasseAlt, String aPlzAlt,
    String aOrtAlt, String aFestnetz, String aMobil, String aIban,  String aBic, 
    String aKontoinhaber, aKreditinstitut) {
    	anrede = aAnrede;
        vorname = aVorame;
        name = aName;
        strasseAlt = aStrasseAlt;
        plzAlt = aPlzAlt;
        ortAlt = aOrtAlt;
        festnetz = aFestnetz;
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
    
    public String getAnrede() {
        return anrede;
    }
    
    public void setAnrede(String aAnrede) {
       anrede = aAnrede;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public void setVorname(String aVorname) {
       vorname = aVorname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String aName) {
       name = aName;
    }
    
    public String getStrasseAlt() {
        return strasseAlt;
    }
    
    public void setStrasseAlt(String aStrasseAlt) {
       strasseAlt = aStrasseAlt;
    }
    
    public String getPlzAlt() {
        return plzAlt;
    }
    
    public void setPlzAlt(String aPlzAlt) {
       plzAlt = aPlzAlt;
    }
    
    public String getOrtAlt() {
        return ortAlt;
    }
    
    public void setOrtAlt(String aOrtAlt) {
       ortAlt = aOrtAlt;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String aEmail) {
       email = aEmail;
    }
    
    public String getFestnetz() {
        return festnetz;
    }
    
    public void setFestnetz(String afestnetz) {
       festnetz = aFestnetz;
    }
    
    public void getMobil() {
       return mobil;
    }
    
    public void setMobil(String aMobil) {
       mobil = aMobil;
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
        mietobjekte.setMieter(this);
    }
    
    public List<Mietkomplex> getMietkomplexe() {
        return mietkomplexe;
    }
    
    public void addMietkomplex(Mietkomplex aMietkomplex) {
        mietkomplexe.add(aMietkomplex);
        mietkomplexe.setMieter(this);
    }
}
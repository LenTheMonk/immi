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
@Table(name = "MIETKOMPLEX")
public class Mietkomplex extends BaseEntity{
	
    @Id
    @GeneratedValue
    @Column(name="MIETKOMPLEX_ID")
    private long id;
        
    @OneToMany(mappedBy = "mietkomplex", cascade = CascadeType.ALL)
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
 
    @ManyToOne
    @JoinColumn(name="MIETER_ID")
    private Mieter mieter;
    
    
    public Mietkomplex() {
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public long setId(aId) {
    	id = aId; 
    }
    
    public void setMietkomplexId(Integer aMietkomplexId) {
    	mietkomplexId = aMietkomplexId;
    }
    
    public List<Mietobjekt> getMietobjekt() {
        return mietobjekte;
    }
    
    public void addMietobjekt(Mietobjekt aMietobjekt) {
        mietobjekte.add(aMietobjekt);
        mietobjekte.setMieter(mieter);
    }
    
    public Mieter getMieter() {
    return mieter;
	}

	public void setMieter(Mieter aMieter) {
    mieter = aMieter;
	}
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

import de.jahresprojekt.persistence.entities.base.BasePojo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
* @author Lukas Eckert
 */
@Entity
@Table(name = Ort.TABLE_NAME, uniqueConstraints =
        { @UniqueConstraint(columnNames = { "name", "plz" }) })
public class Ort extends BasePojo {
    
    public static final String TABLE_NAME = "ORT";
    
    @Id @GeneratedValue
    long id;
    
    String name;
    int plz;
    
    // Default Constructor for PoJo
    public Ort() {
    }
    
    public Ort(String name, int plz) {
        this.name = name;
        this.plz = plz;
    }

    @Override
    public String getTableName() {
        return Ort.TABLE_NAME;
    }
    
    // id

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setID(long iD) {
        this.id = iD;
    }
    
    // Get

    public String getName() {
        return name;
    }

    public int getPlz() {
        return plz;
    }
    
    // Set

    public void setName(String name) {
        this.name = name;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

import de.jahresprojekt.persistence.entities.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * POJO für die Tabelle Ort.
 * @author Lukas Eckert
 */
@Entity
// Über die uniqueConstraints können zusammengesetzte uniques definiert werden
@Table(name = Ort.TABLE_NAME, uniqueConstraints =
        { @UniqueConstraint(columnNames = { "name", "plz" }) })
public class Ort extends BaseEntity {
    
    // Den Namen der Tabelle hier immer statisch deklarieren,
    // die brauchen wir technisch aktuell.
    public static final String TABLE_NAME = "ORT";
    
    // Technischer Schlüssel, wird in allen Pojos so erwartet.
    @Id @GeneratedValue
    long id;
    
    // Alle Sonstigen Felder, die in der Datenbank abgelegt werden sollen
    public static final String MAP_NAME = "name";
    @Column(nullable = false, name = Ort.MAP_NAME)
    String name;
    
    public static final String MAP_PLZ = "plz";
    @Column(nullable = false, name = Ort.MAP_PLZ)
    int plz;
    
    // Felder, die nicht in der Datenbank landen sollen, sind Transient!
    @Transient
    int foo;
    
    // Die Pojos brauchen immer auch einen Default Constructor ohne Argumente.
    public Ort() {
    }
    
    /**
     * Eigene Constructoren können nach belieben erstellt werden.
     * Es sollte aber NIE manuell die ID gesetzt werden. IDs sollen über
     * Hibernate laufen.
     * 
     * @param name Name
     * @param plz Postleitzahl
     */
    public Ort(String name, int plz) {
        this.name = name;
        this.plz = plz;
    }

    // Tabellenname zurückgeben, damit die DAOs wissen, welches die Tabelle ist.
    @Override
    public String getTableName() {
        return Ort.TABLE_NAME;
    }
    
    // Die ID-Getter und Setter sind im Interface vorgeschrieben, darum die
    // Overrides.

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long iD) {
        this.id = iD;
    }
    
    // Getter für alle Datenbank Felder

    public String getName() {
        return name;
    }

    public int getPlz() {
        return plz;
    }
    
    // Setter für alle Datenbank Felder

    public void setName(String name) {
        this.name = name;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.util;


/**
 *
 * @author Lukas Eckert
 */
public abstract class ObjectUtils {
    
    /**
     * Gibt das erste Objekt zurück, welches nicht null ist.Existiert kein entsprechendes Objekt, wird null geliefert.
     * @param <T> Objekttyp
     * @param objects Objekte.
     * @return Erstes T das nicht null ist
     */
    public static <T> T firstNotNull(T... objects){
        if (objects.length == 0){
        }
        T notNullObject = null;
        
        for(T object : objects) {
//            System.out.println("prüfe " + object);
            notNullObject = object;
            if (notNullObject != null) {
//                System.out.println("brk");
                break;
            }
        }
        return notNullObject;
    }
    
}

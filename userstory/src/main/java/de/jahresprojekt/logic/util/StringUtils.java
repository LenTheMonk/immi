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
public abstract class StringUtils {
    
    /**
     * Prüft, ob String null oder leer ist.
     * @param input Input
     * @return true wenn null oder leer
     */
    public static boolean isEmpty(String input) {
        if (input == null) return true;
        return input.isBlank();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Lukas Eckert
 */
public abstract class HashUtils { 
    
    /**
     * Hasht einen String.
     * @param input Input String
     * @return Hash des Strings
     */
    public static String getHash(String input) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            BigInteger number = new BigInteger(1,
                md.digest(input.getBytes(StandardCharsets.UTF_8)));
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 64)
            {
                hexString.insert(0, '0');
            }

            return hexString.toString();
        }
        catch(NoSuchAlgorithmException  e){
            System.out.println("this should happen" + e);
            return null;
        }
    }
    
}

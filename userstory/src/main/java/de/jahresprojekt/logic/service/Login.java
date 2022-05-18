/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.jahresprojekt.logic.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alex
 */
public class Login {
    private String Username;
    private String Password;
    public String Password_Hash;
    
    public void DoLogin(){
        this.Password_Hash = this.GetHash(this.Password);
    }
    
    private String GetHash(String input)
    {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            BigInteger number = new BigInteger(1, md.digest(input.getBytes(StandardCharsets.UTF_8)));
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
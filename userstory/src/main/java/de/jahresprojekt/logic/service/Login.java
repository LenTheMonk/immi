/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.jahresprojekt.logic.service;
package de.jahresprojekt.logic.ClassTypes;

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
    public String Found_UserID;
    public String Password_Hash;
    
    public boolean DoLogin(){
        this.Password_Hash = this.GetHash(this.Password);
        if(this.Password_Hash == "testhash" && this.Username == "TestUsername" ){
            this.Found_UserID = "1";
            return true;
        } 
        else{
            return false;
        }
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

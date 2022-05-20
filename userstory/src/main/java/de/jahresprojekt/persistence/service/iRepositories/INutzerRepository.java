/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service.iRepositories;

import de.jahresprojekt.persistence.entities.Nutzer;
import java.util.Optional;

/**
 *
 * @author Lukas Eckert
 */
public interface INutzerRepository {
    
    /**
     * Liefert den Nutzer basierend auf den Login-Informationen.
     * @param name Benutzername des Nutzers
     * @param hashPw Gehashtes Passwort des Nutzers.
     * @return Nutzer.
     */
    Optional<Nutzer> getNutzerByLogin(String name, String hashPw);
    
}

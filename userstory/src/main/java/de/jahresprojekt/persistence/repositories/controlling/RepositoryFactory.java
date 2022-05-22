/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.repositories.controlling;

import de.jahresprojekt.persistence.repositories.impl.BaseRepository;
import de.jahresprojekt.persistence.repositories.impl.MieterRepository;
import de.jahresprojekt.persistence.repositories.impl.MietobjektRepository;
import de.jahresprojekt.persistence.repositories.impl.OrtRepository;

/**
 *
 * @author Lukas Eckert
 */
public abstract class RepositoryFactory {
    
    private static MieterRepository mieterRepoSingleton;
    private static MietobjektRepository mietobjektRepoSingleton;
    private static OrtRepository ortRepoSingleton;
    
    public static MieterRepository getMieterRepositorySingleton() {
        if (RepositoryFactory.mieterRepoSingleton == null) {
            RepositoryFactory.mieterRepoSingleton = new MieterRepository();
        }
        return RepositoryFactory.mieterRepoSingleton;
    }
    
    public static MietobjektRepository getMietobjektRepositorySingleton() {
        if (RepositoryFactory.mietobjektRepoSingleton == null) {
            RepositoryFactory.mietobjektRepoSingleton = new MietobjektRepository();
        }
        return RepositoryFactory.mietobjektRepoSingleton;
    }
    
    public static OrtRepository getOrtRepositorySingleton() {
        if (RepositoryFactory.ortRepoSingleton == null) {
            RepositoryFactory.ortRepoSingleton = new OrtRepository();
        }
        return RepositoryFactory.ortRepoSingleton;
    }
}

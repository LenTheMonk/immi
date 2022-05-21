/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view.impl;

import de.jahresprojekt.logic.service.impl.MietobjektverwaltungLogikService;
import de.jahresprojekt.persistence.entities.impl.Mietobjekt;
import de.jahresprojekt.persistence.repositories.impl.MietobjektRepository;
import java.sql.Timestamp;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Lukas Eckert
 */
@Named(value = "mietobjektTabelleView")
@SessionScoped
public class MietobjektverwaltungTabelleView extends BaseTabelleView<Mietobjekt,
        MietobjektRepository> {

    public MietobjektverwaltungTabelleView() {
        this.setLogikService(new MietobjektverwaltungLogikService());
        this.init();
    }
    
    @Override
    public void initSortMeta() {
        this.getSortBy().add(
            SortMeta.builder()
                .field(Mietobjekt.MAP_BESCHREIBUNG)
                .order(SortOrder.ASCENDING)
                .priority(1)
                .build());
        
        this.getSortBy().add(
            SortMeta.builder()
                .field(Mietobjekt.MAP_ISTVERMIETET)
                .order(SortOrder.ASCENDING)
                .priority(2)
                .build());
    }

    @Override
    public List<Mietobjekt> getFullList() {
        return super.getFullList();
    }
    
    @Override
    Mietobjekt initNewEntity() {
        return new Mietobjekt("", "", "", "", 0, 0.0d, 0.0d, false, false, new Timestamp(0), new Timestamp(0));
    }

    @Override
    public void remove(Mietobjekt t) {
        System.out.println("obj null: " + (t == null));
        System.out.println("lsite null: " + (this.getFullList() == null));
        this.getFullList().remove(t);
        
        if (t.getId() != 0) {
            this.getLogikService().getRepository().delete(t);
        }
    }
    
    
}

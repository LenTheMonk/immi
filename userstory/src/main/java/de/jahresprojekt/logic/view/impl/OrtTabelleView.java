/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view.impl;

import de.jahresprojekt.logic.service.impl.OrtLogikService;
import de.jahresprojekt.persistence.entities.Ort;
import de.jahresprojekt.persistence.service.OrtRepository;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Lukas Eckert
 */
@Named(value = "ortTabelleView")
@SessionScoped
public class OrtTabelleView extends BaseTabelleView<Ort, OrtRepository> {

    public OrtTabelleView() {
        this.setLogikService(new OrtLogikService());
        this.init();
    }

    @Override
    public List<Ort> getFullList() {
        return super.getFullList();
    }

    @Override
    public void initSortMeta() {
        // Name
        this.getSortBy().add(
            SortMeta.builder()
                .field(Ort.MAP_NAME)
                .order(SortOrder.ASCENDING)
                .priority(1)
                .build());
        // PLZ
        this.getSortBy().add(
            SortMeta.builder()
                .field(Ort.MAP_PLZ)
                .order(SortOrder.ASCENDING)
                .build());
    }

    @Override
    protected Ort initNewEntity() {
        return new Ort("", 0);
    }

    @Override
    public void remove(Ort t) {
        this.getFullList().remove(t);
        
        if(t.getId() != 0) {
            this.getLogikService().getRepository().delete(t);
        }
    }
    
    
    
}

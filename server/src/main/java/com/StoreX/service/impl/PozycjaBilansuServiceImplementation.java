package com.StoreX.service.impl;

import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.service.PozycjaBilansuService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaBilansuServiceImplementation implements PozycjaBilansuService{
    @Autowired
    PozycjaBilansuRepository pozycjaBilansuRepository;

    @Override
    public PozycjaBilansu savePozycjaBilansu(PozycjaBilansu pozycjaBilansu) {
        return getPozycjaBilansuRepository().save(pozycjaBilansu);
    }

    @Override
    public PozycjaBilansu findOne(Long id) {
        return getPozycjaBilansuRepository().findOne(id);
    }

    public PozycjaBilansuRepository getPozycjaBilansuRepository() {
        return pozycjaBilansuRepository;
    }
}

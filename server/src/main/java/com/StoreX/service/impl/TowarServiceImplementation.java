package com.StoreX.service.impl;

import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.persistence.repository.TowarRepository;
import com.StoreX.service.PozycjaBilansuService;
import com.StoreX.service.TowarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TowarServiceImplementation implements TowarService {

    @Autowired
    TowarRepository towarRepository;

    @Override
    public Towar saveTowar(Towar bilans) {
        return getTowarRepository().save(bilans);
    }

    public TowarRepository getTowarRepository() {
        return towarRepository;
    }
}

package com.StoreX.service.impl;

import com.StoreX.persistence.entity.Kategoria;
import com.StoreX.persistence.repository.KategoriaRepository;
import com.StoreX.service.KategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriaServiceImpl implements KategoriaService {

    @Autowired
    KategoriaRepository kategoriaRepository;
    @Override
    public void add(Kategoria kategoria) {
        getKategoriaRepository().save(kategoria);
    }

    public KategoriaRepository getKategoriaRepository() {
        return kategoriaRepository;
    }
}

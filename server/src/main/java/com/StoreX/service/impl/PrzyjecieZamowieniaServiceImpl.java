package com.StoreX.service.impl;

import com.StoreX.persistence.entity.PrzyjecieZamowienia;
import com.StoreX.persistence.repository.PrzyjecieZamowieniaRepository;
import com.StoreX.service.PrzyjecieZamowieniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrzyjecieZamowieniaServiceImpl implements PrzyjecieZamowieniaService {

    @Autowired
    PrzyjecieZamowieniaRepository przyjecieZamowieniaRepository;

    @Override
    public void add(PrzyjecieZamowienia przyjecieZamowienia) {
        getPrzyjecieZamowieniaRepository().save(przyjecieZamowienia);
    }

    public PrzyjecieZamowieniaRepository getPrzyjecieZamowieniaRepository() {
        return przyjecieZamowieniaRepository;
    }
}

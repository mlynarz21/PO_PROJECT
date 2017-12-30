package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.PozycjaPrzyjecia;
import com.StoreX.persistence.repository.PozycjaPrzyjeciaRepository;
import com.StoreX.service.HelperServices.PozycjaPrzyjeciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaPrzyjeciaServiceImpl implements PozycjaPrzyjeciaService {

    @Autowired
    PozycjaPrzyjeciaRepository pozycjaPrzyjeciaRepository;

    @Override
    public void add(PozycjaPrzyjecia pozycjaPrzyjecia) {
        getPozycjaPrzyjeciaRepository().save(pozycjaPrzyjecia);
    }


    public PozycjaPrzyjeciaRepository getPozycjaPrzyjeciaRepository() {
        return pozycjaPrzyjeciaRepository;
    }
}

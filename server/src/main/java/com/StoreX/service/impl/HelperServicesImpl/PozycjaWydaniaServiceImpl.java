package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.PozycjaWydania;
import com.StoreX.persistence.repository.PozycjaWydaniaRepository;
import com.StoreX.service.HelperServices.PozycjaWydaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaWydaniaServiceImpl implements PozycjaWydaniaService {

    @Autowired
    PozycjaWydaniaRepository pozycjaWydaniaRepository;



    @Override
    public void add(PozycjaWydania pozycjaWydania) {
        getPozycjaWydaniaRepository().save(pozycjaWydania);
    }

    public PozycjaWydaniaRepository getPozycjaWydaniaRepository() {
        return pozycjaWydaniaRepository;
    }
}

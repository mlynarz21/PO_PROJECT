package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PrzyjecieZamowienia;
import com.StoreX.persistence.repository.PrzyjecieWydanieRepository.PrzyjecieZamowieniaRepository;
import com.StoreX.service.HelperServices.PrzyjecieZamowieniaService;
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

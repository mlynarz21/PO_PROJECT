package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.Klient;
import com.StoreX.persistence.repository.KlientRepository;
import com.StoreX.service.HelperServices.KlientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlientServiceImpl implements KlientService {

    @Autowired
    KlientRepository klientRepository;

    @Override
    public void add(Klient klient) {
        getKlientRepository().save(klient);
    }

    public KlientRepository getKlientRepository() {
        return klientRepository;
    }
}

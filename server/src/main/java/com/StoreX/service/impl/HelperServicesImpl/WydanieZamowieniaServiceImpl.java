package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.WydanieZamowienia;
import com.StoreX.persistence.repository.WydanieZamowieniaRepository;
import com.StoreX.service.HelperServices.WydanieZamowieniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WydanieZamowieniaServiceImpl implements WydanieZamowieniaService {

    @Autowired
    WydanieZamowieniaRepository wydanieZamowieniaRepository;

    @Override
    public void add(WydanieZamowienia wydanieZamowienia) {
        getWydanieZamowieniaRepository().save(wydanieZamowienia);
    }

    public WydanieZamowieniaRepository getWydanieZamowieniaRepository() {
        return wydanieZamowieniaRepository;
    }
}

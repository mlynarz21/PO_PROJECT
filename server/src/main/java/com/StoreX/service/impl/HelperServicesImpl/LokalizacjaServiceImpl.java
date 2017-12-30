package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.Lokalizacja;
import com.StoreX.persistence.repository.LokalizacjaRepository;
import com.StoreX.service.HelperServices.LokalizacjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LokalizacjaServiceImpl implements LokalizacjaService {

    @Autowired
    LokalizacjaRepository lokalizacjaRepository;

    @Override
    public void add(Lokalizacja lokalizacja) {
        getLokalizacjaRepository().save(lokalizacja);
    }

    public LokalizacjaRepository getLokalizacjaRepository() {
        return lokalizacjaRepository;
    }
}

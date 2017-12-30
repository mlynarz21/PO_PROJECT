package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.Umieszczenie;
import com.StoreX.persistence.repository.UmieszczenieRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.HelperServices.UmieszczenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmieszczenieServiceImpl implements UmieszczenieService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    UmieszczenieRepository umieszczenieRepository;


    @Override
    public void addService(Umieszczenie umieszczenie) {
        getUmieszczenieRepository().save(umieszczenie);
    }


    public UmieszczenieRepository getUmieszczenieRepository() {
        return umieszczenieRepository;
    }
}

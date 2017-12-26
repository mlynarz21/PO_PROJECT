package com.StoreX.service.impl;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.repository.BilansRepository;
import com.StoreX.service.BilansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BilansServiceImplementation implements BilansService {

    @Autowired
    BilansRepository bilansRepository;


    @Override
    public Bilans saveBilans(Bilans bilans) {
            return getBilansRepository().save(bilans);
    }

    public BilansRepository getBilansRepository() {
        return bilansRepository;
    }
}

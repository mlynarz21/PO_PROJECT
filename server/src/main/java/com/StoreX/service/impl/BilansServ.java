package com.StoreX.service.impl;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.repository.BilansRepository;
import com.StoreX.service.BilansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BilansServ implements BilansService {

    @Autowired
    BilansRepository bilansRepository;


    @Override
    public Bilans saveUser(Bilans user) {
            return getBilansRepository().save(user);
    }

    public BilansRepository getBilansRepository() {
        return bilansRepository;
    }
}

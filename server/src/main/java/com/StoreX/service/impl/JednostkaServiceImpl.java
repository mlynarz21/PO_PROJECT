package com.StoreX.service.impl;

import com.StoreX.persistence.entity.Jednostka;
import com.StoreX.persistence.repository.JednostkaRepository;
import com.StoreX.service.JednostkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JednostkaServiceImpl implements JednostkaService {

    @Autowired
    JednostkaRepository jednostkaRepository;
    @Override
    public void add(Jednostka jednostka) {
        getJednostkaRepository().save(jednostka);
    }

    public JednostkaRepository getJednostkaRepository() {
        return jednostkaRepository;
    }
}

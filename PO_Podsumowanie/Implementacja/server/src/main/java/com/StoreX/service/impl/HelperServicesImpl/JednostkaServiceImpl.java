package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.TowarEntities.Jednostka;
import com.StoreX.persistence.repository.TowarRepository.JednostkaRepository;
import com.StoreX.service.HelperServices.JednostkaService;
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

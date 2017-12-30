package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.repository.TowarRepository;
import com.StoreX.service.HelperServices.TowarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TowarServiceImplementation implements TowarService {

    @Autowired
    TowarRepository towarRepository;

    @Override
    public Towar saveTowar(Towar bilans) {
        return getTowarRepository().save(bilans);
    }

    @Override
    public Towar getById(Long id) {
       return  getTowarRepository().findOne(id);
    }

    public TowarRepository getTowarRepository() {
        return towarRepository;
    }
}

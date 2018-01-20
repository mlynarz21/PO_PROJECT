package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.BilansEntities.Bilans;
import com.StoreX.persistence.repository.BilansRepository.BilansRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.HelperServices.BilansService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilansServiceImpl implements BilansService {


    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    BilansRepository bilansRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public void saveBilans(Bilans b2) {
        getBilansRepository().save(b2);
    }

    public BilansRepository getBilansRepository() {
        return bilansRepository;
    }
}

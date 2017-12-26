package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.repository.BilansRepository;
import com.StoreX.service.AuthorizationService;
import com.StoreX.service.BilansService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.UUID;

@Service
public class BilansServiceImplementation implements BilansService {


    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    BilansRepository bilansRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public Bilans saveBilans(Bilans bilans) {
            return getBilansRepository().save(bilans);
    }

    @Override
    public Bilans findOne(Long id) {
        return getBilansRepository().findOne(id);
    }

    @Override
    public BilansBO findLast(String sessionId)throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
            }
        Bilans lastBilans =  getBilansRepository().findLastBilansByDate();

        return modelMapper.map(lastBilans, BilansBO.class);
    }

    public BilansRepository getBilansRepository() {
        return bilansRepository;
    }
}

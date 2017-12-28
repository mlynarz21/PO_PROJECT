package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.UmieszczenieBO;
import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.StoreX.persistence.entity.Umieszczenie;
import com.StoreX.persistence.repository.UmieszczenieRepository;
import com.StoreX.service.AuthorizationService;
import com.StoreX.service.UmieszczenieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UmieszczenieServiceImpl implements UmieszczenieService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    UmieszczenieRepository umieszczenieRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addService(Umieszczenie umieszczenie) {
        getUmieszczenieRepository().save(umieszczenie);
    }

    @Override
    public List<UmieszczenieBO> findAllForTowar(String sessionId, Long ID)throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            // throw new AuthenticationException();
        }
        List<Umieszczenie> umieszczenieList = getUmieszczenieRepository().findAllForTowar(ID);

        List<UmieszczenieBO> resultBO = new ArrayList<>();

        for (Umieszczenie umieszczenie : umieszczenieList) {
            resultBO.add(modelMapper.map(umieszczenie, UmieszczenieBO.class));
        }

        return resultBO;

    }

    public UmieszczenieRepository getUmieszczenieRepository() {
        return umieszczenieRepository;
    }
}

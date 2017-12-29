package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.service.PozycjaBilansuService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaBilansuServiceImplementation implements PozycjaBilansuService{
    @Autowired
    PozycjaBilansuRepository pozycjaBilansuRepository;

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public PozycjaBilansu savePozycjaBilansu(PozycjaBilansu pozycjaBilansu) {
        return getPozycjaBilansuRepository().save(pozycjaBilansu);
    }

    @Override
    public PozycjaBilansu findOne(Long id) {
        return getPozycjaBilansuRepository().findOne(id);
    }

    @Override
    public List<PozycjaBilansuBO> findAllForBilans(Long id) throws AuthenticationException{

        //if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
        // throw new AuthenticationException();
        //}
        List<PozycjaBilansu> pozycjaBilansuList = getPozycjaBilansuRepository().findAllForBilans(id);
        List<PozycjaBilansuBO> resultBO = new ArrayList<>();

        for (PozycjaBilansu pozycjaBilansu : pozycjaBilansuList) {
            resultBO.add(modelMapper.map(pozycjaBilansu, PozycjaBilansuBO.class));
        }

        return resultBO;
    }

    public PozycjaBilansuRepository getPozycjaBilansuRepository() {
        return pozycjaBilansuRepository;
    }
}

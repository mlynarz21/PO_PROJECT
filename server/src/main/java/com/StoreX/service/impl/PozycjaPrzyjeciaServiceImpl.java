package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;
import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.entity.PozycjaPrzyjecia;
import com.StoreX.persistence.repository.PozycjaPrzyjeciaRepository;
import com.StoreX.service.PozycjaPrzyjeciaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaPrzyjeciaServiceImpl implements PozycjaPrzyjeciaService {

    @Autowired
    PozycjaPrzyjeciaRepository pozycjaPrzyjeciaRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PozycjaPrzyjeciaBO> findAllForMonthAndYear(int Month, int Year)throws AuthenticationException {

        //if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
        // throw new AuthenticationException();
        //}
        List<PozycjaPrzyjecia> pozycjaPrzyjeciaList = getPozycjaPrzyjeciaRepository().findAllForMonthAndYear(Month, Year);

        List<PozycjaPrzyjeciaBO> resultBO = new ArrayList<>();

        for (PozycjaPrzyjecia pozycjaPrzyjecia : pozycjaPrzyjeciaList) {
            resultBO.add(modelMapper.map(pozycjaPrzyjecia, PozycjaPrzyjeciaBO.class));
        }

        return resultBO;
    }

    @Override
    public void add(PozycjaPrzyjecia pozycjaPrzyjecia) {
        getPozycjaPrzyjeciaRepository().save(pozycjaPrzyjecia);
    }


    public PozycjaPrzyjeciaRepository getPozycjaPrzyjeciaRepository() {
        return pozycjaPrzyjeciaRepository;
    }
}

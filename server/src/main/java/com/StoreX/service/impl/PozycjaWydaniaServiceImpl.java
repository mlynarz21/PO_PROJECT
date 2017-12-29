package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;
import com.StoreX.common.datatypes.bo.PozycjaWydaniaBO;
import com.StoreX.persistence.entity.PozycjaPrzyjecia;
import com.StoreX.persistence.entity.PozycjaWydania;
import com.StoreX.persistence.repository.PozycjaWydaniaRepository;
import com.StoreX.service.PozycjaWydaniaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaWydaniaServiceImpl implements PozycjaWydaniaService {

    @Autowired
    PozycjaWydaniaRepository pozycjaWydaniaRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PozycjaWydaniaBO> findAllForMonthAndYear(int Month, int Year) throws AuthenticationException {
        //if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
        // throw new AuthenticationException();
        //}
        List<PozycjaWydania> pozycjaWydaniaList = getPozycjaWydaniaRepository().findAllForMonthAndYear(Month, Year);


        List<PozycjaWydaniaBO> resultBO = new ArrayList<>();

        for (PozycjaWydania pozycjaWydania : pozycjaWydaniaList) {
            resultBO.add(modelMapper.map(pozycjaWydania, PozycjaWydaniaBO.class));
        }

        return resultBO;
    }

    @Override
    public void add(PozycjaWydania pozycjaWydania) {
        getPozycjaWydaniaRepository().save(pozycjaWydania);
    }

    public PozycjaWydaniaRepository getPozycjaWydaniaRepository() {
        return pozycjaWydaniaRepository;
    }
}

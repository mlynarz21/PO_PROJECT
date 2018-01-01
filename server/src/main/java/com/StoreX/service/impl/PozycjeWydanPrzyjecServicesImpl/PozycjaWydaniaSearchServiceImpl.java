package com.StoreX.service.impl.PozycjeWydanPrzyjecServicesImpl;

import com.StoreX.common.datatypes.bo.PozycjaWydaniaBO;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaWydania;
import com.StoreX.persistence.repository.PrzyjecieWydanieRepository.PozycjaWydaniaRepository;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaWydaniaFindService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaWydaniaSearchServiceImpl implements PozycjaWydaniaFindService {

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

    public PozycjaWydaniaRepository getPozycjaWydaniaRepository() {
        return pozycjaWydaniaRepository;
    }
}

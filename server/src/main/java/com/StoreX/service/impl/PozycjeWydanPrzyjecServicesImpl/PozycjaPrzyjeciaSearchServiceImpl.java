package com.StoreX.service.impl.PozycjeWydanPrzyjecServicesImpl;

import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaPrzyjecia;
import com.StoreX.persistence.repository.PrzyjecieWydanieRepository.PozycjaPrzyjeciaRepository;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaPrzyjeciaSearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaPrzyjeciaSearchServiceImpl implements PozycjaPrzyjeciaSearchService {

    @Autowired
    PozycjaPrzyjeciaRepository pozycjaPrzyjeciaRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PozycjaPrzyjeciaBO> findAllForMonthAndYear(int Month, int Year)throws AuthenticationException {

        List<PozycjaPrzyjecia> pozycjaPrzyjeciaList = getPozycjaPrzyjeciaRepository().findAllForMonthAndYear(Month, Year);

        List<PozycjaPrzyjeciaBO> resultBO = new ArrayList<>();

        for (PozycjaPrzyjecia pozycjaPrzyjecia : pozycjaPrzyjeciaList) {
            resultBO.add(modelMapper.map(pozycjaPrzyjecia, PozycjaPrzyjeciaBO.class));
        }

        return resultBO;
    }

    public PozycjaPrzyjeciaRepository getPozycjaPrzyjeciaRepository() {
        return pozycjaPrzyjeciaRepository;
    }
}

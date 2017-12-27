package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.ZamowienieBO;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.StoreX.persistence.entity.ZamowienieZakupu;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.persistence.repository.PozycjaZamowieniaRepository;
import com.StoreX.service.PozycjaZamowieniaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaZamowieniaServiceImpl implements PozycjaZamowieniaService {

    @Autowired
    PozycjaZamowieniaRepository pozycjaZamowieniaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PozycjaZamowieniaBO> findAllforZamowienie(ZamowienieZakupuBO zamowienieBO) throws AuthenticationException{
        List<PozycjaZamowienia> pozycjaZamowieniaList = getPozycjaZamowieniaRepository().findAllForZamowienie(zamowienieBO.getID());
        List<PozycjaZamowieniaBO> resultBO = new ArrayList<>();

        for (PozycjaZamowienia pozycjaZamowienia : pozycjaZamowieniaList) {
            resultBO.add(modelMapper.map(pozycjaZamowienia, PozycjaZamowieniaBO.class));
        }

        return resultBO;

    }

    @Override
    public void add(PozycjaZamowienia pozycjaZamowienia) {
        getPozycjaZamowieniaRepository().save(pozycjaZamowienia);
    }

    public PozycjaZamowieniaRepository getPozycjaZamowieniaRepository() {
        return pozycjaZamowieniaRepository;
    }
}

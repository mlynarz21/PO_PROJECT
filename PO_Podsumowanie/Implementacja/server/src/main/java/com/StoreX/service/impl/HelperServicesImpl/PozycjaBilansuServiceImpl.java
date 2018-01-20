package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu;
import com.StoreX.persistence.repository.BilansRepository.PozycjaBilansuRepository;
import com.StoreX.service.HelperServices.PozycjaBilansuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaBilansuServiceImpl implements PozycjaBilansuService{
    @Autowired
    PozycjaBilansuRepository pozycjaBilansuRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public PozycjaBilansu findOne(Long id) {
        return getPozycjaBilansuRepository().findOne(id);
    }

    @Override
    public void add(PozycjaBilansu pozycjaBilansu) {
        getPozycjaBilansuRepository().save(pozycjaBilansu);
    }


    public PozycjaBilansuRepository getPozycjaBilansuRepository() {
        return pozycjaBilansuRepository;
    }
}

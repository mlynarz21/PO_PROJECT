package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.service.HelperServices.PozycjaBilansuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaBilansuServiceImplementation implements PozycjaBilansuService{
    @Autowired
    PozycjaBilansuRepository pozycjaBilansuRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public PozycjaBilansu findOne(Long id) {
        return getPozycjaBilansuRepository().findOne(id);
    }



    public PozycjaBilansuRepository getPozycjaBilansuRepository() {
        return pozycjaBilansuRepository;
    }
}

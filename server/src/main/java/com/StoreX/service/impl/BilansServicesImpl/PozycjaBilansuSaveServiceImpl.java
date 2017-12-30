package com.StoreX.service.impl.BilansServicesImpl;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.service.BilansServices.PozycjaBilansuSaveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaBilansuSaveServiceImpl implements PozycjaBilansuSaveService {
    @Autowired
    PozycjaBilansuRepository pozycjaBilansuRepository;

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public void savePozycjaBilansu(PozycjaBilansuBO pozycjaBilansuBO) {
        PozycjaBilansu pozycjaBilansu = modelMapper.map(pozycjaBilansuBO, PozycjaBilansu.class);
        getPozycjaBilansuRepository().save(pozycjaBilansu);
    }

    public PozycjaBilansuRepository getPozycjaBilansuRepository() {
        return pozycjaBilansuRepository;
    }
}

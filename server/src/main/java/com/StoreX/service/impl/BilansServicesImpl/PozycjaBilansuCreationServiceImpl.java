package com.StoreX.service.impl.BilansServicesImpl;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;
import com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu;
import com.StoreX.persistence.repository.BilansRepository.PozycjaBilansuRepository;
import com.StoreX.service.BilansServices.PozycjaBilansuCreationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaBilansuCreationServiceImpl implements PozycjaBilansuCreationService {
    @Autowired
    PozycjaBilansuRepository pozycjaBilansuRepository;

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public boolean savePozycjaBilansu(PozycjaBilansuBO pozycjaBilansuBO) {
        PozycjaBilansu pozycjaBilansu = modelMapper.map(pozycjaBilansuBO, PozycjaBilansu.class);
        getPozycjaBilansuRepository().save(pozycjaBilansu);
        return true;
    }

    public PozycjaBilansuRepository getPozycjaBilansuRepository() {
        return pozycjaBilansuRepository;
    }
}

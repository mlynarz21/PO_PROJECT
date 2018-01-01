package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.ZamowienieEntities.PozycjaZamowienia;
import com.StoreX.persistence.repository.ZamowienieRepository.PozycjaZamowieniaRepository;
import com.StoreX.persistence.repository.UmieszczenieRepository.UmieszczenieRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.HelperServices.PozycjaZamowieniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PozycjaZamowieniaServiceImpl implements PozycjaZamowieniaService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    PozycjaZamowieniaRepository pozycjaZamowieniaRepository;
    @Autowired
    UmieszczenieRepository umieszczenieRepository;






    @Override
    public void add(PozycjaZamowienia pozycjaZamowienia) {
        getPozycjaZamowieniaRepository().save(pozycjaZamowienia);
    }

    public PozycjaZamowieniaRepository getPozycjaZamowieniaRepository() {
        return pozycjaZamowieniaRepository;
    }
    public UmieszczenieRepository getUmieszczenieRepository() {
        return umieszczenieRepository;
    }
}

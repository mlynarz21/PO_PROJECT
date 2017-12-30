package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.ZamowienieZakupu;
import com.StoreX.persistence.repository.ZamowienieZakupuRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.HelperServices.ZamowienieZakupuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZamowienieZakupuServiceImplementation implements ZamowienieZakupuService {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    ZamowienieZakupuRepository zamowienieZakupuRepository;


    @Override
    public Boolean addZamowienie(String sessionId, ZamowienieZakupu zamowienieZakupu) {
        ZamowienieZakupu b = zamowienieZakupuRepository.save(zamowienieZakupu);
        return b != null;
    }
}

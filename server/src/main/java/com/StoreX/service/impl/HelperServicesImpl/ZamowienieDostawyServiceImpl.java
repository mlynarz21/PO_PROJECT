package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.ZamowienieDostawy;
import com.StoreX.persistence.repository.ZamowienieDostawyRepository;
import com.StoreX.service.HelperServices.ZamowienieDostawyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZamowienieDostawyServiceImpl implements ZamowienieDostawyService {

    @Autowired
    ZamowienieDostawyRepository zamowienieDostawyRepository;

    @Override
    public void add(ZamowienieDostawy zamowienieDostawy) {
        getZamowienieDostawyRepository().save(zamowienieDostawy);
    }

    public ZamowienieDostawyRepository getZamowienieDostawyRepository() {
        return zamowienieDostawyRepository;
    }
}

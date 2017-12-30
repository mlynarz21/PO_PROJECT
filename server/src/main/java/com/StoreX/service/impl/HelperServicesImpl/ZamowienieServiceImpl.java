package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.Zamowienie;
import com.StoreX.persistence.repository.ZamowienieRepositroy;
import com.StoreX.service.HelperServices.ZamowienieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZamowienieServiceImpl implements ZamowienieService {

    @Autowired
    ZamowienieRepositroy zamowienieRepositroy;

    @Override
    public void add(Zamowienie zamowienie) {
        getZamowienieRepositroy().save(zamowienie);
    }

    public ZamowienieRepositroy getZamowienieRepositroy() {
        return zamowienieRepositroy;
    }
}

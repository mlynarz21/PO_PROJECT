package com.StoreX.service;

import com.StoreX.persistence.entity.Zamowienie;
import com.StoreX.persistence.entity.ZamowienieDostawy;
import org.springframework.stereotype.Repository;

public interface ZamowienieDostawyService {

    void add(ZamowienieDostawy zamowienieDostawy);
}

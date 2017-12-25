package com.StoreX.api;

import com.StoreX.common.datatypes.to.ZamowienieTO;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZamowienieZakupuApi {

    ResponseEntity<List<ZamowienieZakupuTO>> getAllZaakceptowane(String sessionId);

    ResponseEntity<Boolean> updateStatusZamowienieZakupu(ZamowienieZakupuTO zamowienie, String sessionId);

}

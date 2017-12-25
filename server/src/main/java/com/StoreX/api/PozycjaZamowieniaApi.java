package com.StoreX.api;

import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.common.datatypes.to.ZamowienieTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PozycjaZamowieniaApi {

    ResponseEntity<List<PozycjaZamowieniaTO>> getPozycjeZamowienia(ZamowienieTO zamowienie, String sessionId);

    ResponseEntity<Boolean> updatePozycjaZamowienia(PozycjaZamowieniaTO pozycjaZamowienia, String sessionId);

}


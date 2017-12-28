package com.StoreX.api;

import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PozycjaZamowieniaApi {

    ResponseEntity<List<PozycjaZamowieniaTO>> getPozycjeZamowienia(Long ID, String sessionId);

    //ResponseEntity<Boolean> updatePozycjaZamowienia(PozycjaZamowieniaTO pozycjaZamowienia, String sessionId);

    ResponseEntity<Boolean> proceedPozycjaZamowienia(List<Double> transferList, String sessionId);

    //ResponseEntity<Boolean> proceedPozycjaZamowienia(String sessionId);
}


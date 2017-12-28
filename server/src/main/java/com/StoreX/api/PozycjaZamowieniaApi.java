package com.StoreX.api;

import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.common.datatypes.to.ZamowienieTO;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PozycjaZamowieniaApi {

    ResponseEntity<List<PozycjaZamowieniaTO>> getPozycjeZamowienia(Long ID, String sessionId);

    ResponseEntity<Boolean> updatePozycjaZamowienia(PozycjaZamowieniaTO pozycjaZamowienia, String sessionId);

    ResponseEntity<Boolean> proceedPozycjaZamowienia(  Long idPozycji, Long idUmieszczniea, double ilosc, String sessionId);

}


package com.StoreX.api;

import com.StoreX.common.datatypes.to.TowarTO;
import com.StoreX.common.datatypes.to.UmieszczenieTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UmieszczenieApi {

    ResponseEntity<List<UmieszczenieTO>> getUmieszczenieTowaru(Long id, String sessionId);

    ResponseEntity<Boolean> updateUmieszczenie(UmieszczenieTO umieszczenie, String sessionId);



}

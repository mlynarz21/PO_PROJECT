package com.StoreX.api;

import com.StoreX.common.datatypes.to.BilansTO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface BilansApi {

    ResponseEntity<BilansTO> getLastBilans(String sessionId);

    ResponseEntity<Boolean> addBilans(Date dataBilansowana, String sessionId);

    //ResponseEntity<Boolean> addBilans( String sessionId);

    /*
    To be removed, created for test purposes
     */
    ResponseEntity<Long> addBilansTest(Date dataBilansowana, String sessionId);

    ResponseEntity<List<PozycjaZamowieniaTO>> addTest(String sessionId);
}

package com.StoreX.api;

import com.StoreX.common.datatypes.to.BilansTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface BilansApi {

    ResponseEntity<BilansTO> getLastBilans(String sessionId);

    ResponseEntity<Boolean> addBilans(Date dataBilansowana, String sessionId);

    /*
    To be removed, created for test purposes
     */
    ResponseEntity<Long> addBilansTest(Date dataBilansowana, String sessionId);
}

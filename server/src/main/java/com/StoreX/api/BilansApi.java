package com.StoreX.api;

import com.StoreX.common.datatypes.to.BilansTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface BilansApi {

    ResponseEntity<BilansTO> getLastBilans(String sessionId);

    ResponseEntity<Boolean> addBilans(Date dataBilansowana, String sessionId);

}

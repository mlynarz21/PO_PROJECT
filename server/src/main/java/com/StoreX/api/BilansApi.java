package com.StoreX.api;

import com.StoreX.common.datatypes.to.ArtifactTo;
import com.StoreX.common.datatypes.to.BilansTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BilansApi {

    ResponseEntity<BilansTO> getLastBilans(String sessionId);

    ResponseEntity<Boolean> addBilans(BilansTO incomingBilansTO,String sessionId);

}

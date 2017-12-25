package com.StoreX.api;

import com.StoreX.common.datatypes.to.KlientTO;
import org.springframework.http.ResponseEntity;

public interface KlientApi {

    ResponseEntity<KlientTO> getKlient(KlientTO klient, String sessionId);

}

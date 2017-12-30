package com.StoreX.service.UmieszczenieServices;

import com.StoreX.common.datatypes.bo.UmieszczenieBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UmieszczenieFindService {
    List<UmieszczenieBO> findAllForTowar(String sessionId, Long ID) throws AuthenticationException;
}

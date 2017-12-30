package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.BilansBO;

import javax.naming.AuthenticationException;

public interface BilansFindService {
    public BilansBO findLast(String sessionId) throws AuthenticationException;
}

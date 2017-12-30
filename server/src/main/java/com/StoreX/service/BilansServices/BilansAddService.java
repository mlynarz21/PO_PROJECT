package com.StoreX.service.BilansServices;

import javax.naming.AuthenticationException;
import java.util.Date;

public interface BilansAddService {
    public boolean addBilans(String sessionId, Date dataBilansowana) throws AuthenticationException, Exception;
}

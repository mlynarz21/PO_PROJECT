package com.StoreX.service;

import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.persistence.entity.Bilans;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.naming.AuthenticationException;
import java.util.Date;

public interface BilansService {

    public boolean addBilans(String sessionId, Date dataBilansowana) throws AuthenticationException, Exception;

    public BilansBO findLast(String sessionId) throws AuthenticationException;


    void saveBilans(Bilans b2);
}

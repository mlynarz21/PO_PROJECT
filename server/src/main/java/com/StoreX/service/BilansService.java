package com.StoreX.service;

import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.persistence.entity.Bilans;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.naming.AuthenticationException;

public interface BilansService {

    public Bilans saveBilans(Bilans bilans);

    public Bilans findOne(Long id);

    public BilansBO findLast(String sessionId) throws AuthenticationException;;
}

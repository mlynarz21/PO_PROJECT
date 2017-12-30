package com.StoreX.service.HelperServices;

import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.persistence.entity.Bilans;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.naming.AuthenticationException;
import java.util.Date;

public interface BilansService {


    void saveBilans(Bilans b2);
}

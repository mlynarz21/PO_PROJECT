package com.StoreX.service;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaBilansuService {
    public PozycjaBilansu savePozycjaBilansu(PozycjaBilansu pozycjaBilansu);

    public PozycjaBilansu findOne(Long id);

    public List<PozycjaBilansuBO> findAllForBilans(Long id) throws AuthenticationException;
}

package com.StoreX.service;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.sun.xml.internal.bind.v2.model.core.ID;

public interface PozycjaBilansuService {
    public PozycjaBilansu savePozycjaBilansu(PozycjaBilansu pozycjaBilansu);

    public PozycjaBilansu findOne(Long id);
}

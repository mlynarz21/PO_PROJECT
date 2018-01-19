package com.StoreX.service.HelperServices;

import com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu;

public interface PozycjaBilansuService {

    PozycjaBilansu findOne(Long id);

    void add(PozycjaBilansu pozycjaBilansu);
}

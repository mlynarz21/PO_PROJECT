package com.StoreX.service.HelperServices;

import com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu;

public interface PozycjaBilansuService {

    public PozycjaBilansu findOne(Long id);

    public void add(PozycjaBilansu pozycjaBilansu);
}

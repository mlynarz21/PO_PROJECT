package com.StoreX.service.HelperServices;

import com.StoreX.persistence.entity.TowarEntities.Towar;

public interface TowarService {
    public Towar saveTowar(Towar towar);
    public Towar getById(Long id);
}

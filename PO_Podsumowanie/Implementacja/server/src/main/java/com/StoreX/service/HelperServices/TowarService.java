package com.StoreX.service.HelperServices;

import com.StoreX.persistence.entity.TowarEntities.Towar;

public interface TowarService {
    Towar saveTowar(Towar towar);
    Towar getById(Long id);
}

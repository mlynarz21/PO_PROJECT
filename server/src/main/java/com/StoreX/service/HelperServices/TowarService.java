package com.StoreX.service.HelperServices;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.Towar;

public interface TowarService {
    public Towar saveTowar(Towar towar);
    public Towar getById(Long id);
}

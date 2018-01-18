package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;

public interface PozycjaBilansuCreationService {
    /**
     * Dodaje pozycję Bilansu
     * @param pozycjaBilansu
     */
    public boolean savePozycjaBilansu(PozycjaBilansuBO pozycjaBilansu);
}
package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;

public interface PozycjaBilansuCreationService {
    /**
     * Dodaje pozycję Bilansu
     * @param pozycjaBilansu
     */
    public void savePozycjaBilansu(PozycjaBilansuBO pozycjaBilansu);
}

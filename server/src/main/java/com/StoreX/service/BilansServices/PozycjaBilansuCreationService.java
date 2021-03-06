package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;

public interface PozycjaBilansuCreationService {
    /**
     * Dodaje pozycję Bilansu
     * @param pozycjaBilansu pozycja bilansu do dodania do bazy
     */
    boolean savePozycjaBilansu(PozycjaBilansuBO pozycjaBilansu);
}

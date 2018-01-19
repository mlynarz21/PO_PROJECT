package com.StoreX.service.BilansServices;

import javax.naming.AuthenticationException;
import java.util.Date;


public interface BilansCreationService {
    /**
     * Dodaje bilans z aktualną datą jako data wykonania bilansu oraz datą bilansowaną przekazaną w parametrze
     * @param sessionId Id sesji
     * @param dataBilansowana Data bilansowanego miesiąca
     * @return Informacja o powodzeniu operacji
     * @throws AuthenticationException
     * @throws Exception
     */
    boolean addBilans(String sessionId, Date dataBilansowana) throws AuthenticationException, Exception;
}

package com.StoreX.service;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.ZamowienieBO;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.StoreX.persistence.entity.Zamowienie;
import com.StoreX.persistence.entity.ZamowienieZakupu;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;


public interface PozycjaZamowieniaService {

    List<PozycjaZamowieniaBO> findAllforZamowienie(Long ID) throws AuthenticationException;

    boolean ProceedPozycjaZamowienia(String sessionId, Long idPozycji, Long idUmieszczenia, double ilosc) throws AuthenticationException;
    /*
    to be deleted
     */
    void add(PozycjaZamowienia pozycjaZamowienia);
}

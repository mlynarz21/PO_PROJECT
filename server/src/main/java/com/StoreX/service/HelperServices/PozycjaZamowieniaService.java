package com.StoreX.service.HelperServices;

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

    /*
    to be deleted
     */
    void add(PozycjaZamowienia pozycjaZamowienia);
}

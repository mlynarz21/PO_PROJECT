package com.StoreX.service.HelperServices;

import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.persistence.entity.ZamowienieZakupu;

import javax.naming.AuthenticationException;
import java.util.List;


public interface ZamowienieZakupuService {
    /*
    test method, to be removed
     */
    public Boolean addZamowienie(String sessionId ,ZamowienieZakupu zamowienieZakupu);

}

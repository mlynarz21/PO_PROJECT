package com.StoreX.service;

import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.persistence.entity.ZamowienieZakupu;

import javax.naming.AuthenticationException;
import java.util.List;


public interface ZamowienieZakupuService {
    public List<ZamowienieZakupuBO> findAllAccepted(String sessionId) throws AuthenticationException;
    public void updateStatusZamowienia(String sessionId, ZamowienieZakupuBO zamowienieZakupuBO) throws AuthenticationException;

    /*
    test method, to be removed
     */
    public Boolean addZamowienie(String sessionId ,ZamowienieZakupu zamowienieZakupu);

}

package com.StoreX.service.ZamowienieServices;

import javax.naming.AuthenticationException;

public interface ZamowienieZakupuUpdateService {
    public void updateStatusZamowienia(String sessionId, Long ID) throws AuthenticationException;
}

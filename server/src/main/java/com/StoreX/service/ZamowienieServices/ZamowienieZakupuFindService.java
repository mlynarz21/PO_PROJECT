package com.StoreX.service.ZamowienieServices;

import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ZamowienieZakupuFindService {
    public List<ZamowienieZakupuBO> findAllAccepted(String sessionId) throws AuthenticationException;
}

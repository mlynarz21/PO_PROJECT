package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaBilansuFindService {
    public List<PozycjaBilansuBO> findAllForBilans(Long id) throws AuthenticationException;
}

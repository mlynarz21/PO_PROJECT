package com.StoreX.service;

import com.StoreX.common.datatypes.bo.UmieszczenieBO;
import com.StoreX.persistence.entity.Umieszczenie;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UmieszczenieService {

    void addService(Umieszczenie umieszczenie);

    List<UmieszczenieBO> findAllForTowar(String sessionId, Long ID) throws AuthenticationException;
}

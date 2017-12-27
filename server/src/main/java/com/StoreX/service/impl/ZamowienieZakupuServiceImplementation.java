package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.ZamowienieZakupu;
import com.StoreX.persistence.repository.ZamowienieZakupuRepository;
import com.StoreX.service.AuthorizationService;
import com.StoreX.service.ZamowienieZakupuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ZamowienieZakupuServiceImplementation implements ZamowienieZakupuService {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    ZamowienieZakupuRepository zamowienieZakupuRepository;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<ZamowienieZakupuBO> findAllAccepted(String sessionId) throws AuthenticationException {

        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            // throw new AuthenticationException();
        }

        List<ZamowienieZakupu> result = zamowienieZakupuRepository.findAllAccepted();
        List<ZamowienieZakupuBO> resultBO = new ArrayList<>();

        for (ZamowienieZakupu zamowienie : result) {
            resultBO.add(modelMapper.map(zamowienie, ZamowienieZakupuBO.class));
        }

        return resultBO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateStatusZamowienia(String sessionId, ZamowienieZakupuBO zamowienieZakupuBO) throws AuthenticationException {
      //  if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            // throw new AuthenticationException();
      //  }
        ZamowienieZakupu zamowienieZakupu = modelMapper.map(zamowienieZakupuBO, ZamowienieZakupu.class);

        zamowienieZakupuRepository.updateStatusZamowienia(zamowienieZakupu.getID(), zamowienieZakupu.getStatus().toString());
    }

    @Override
    public Boolean addZamowienie(String sessionId, ZamowienieZakupu zamowienieZakupu) {
        ZamowienieZakupu b = zamowienieZakupuRepository.save(zamowienieZakupu);
        return b != null;
    }
}

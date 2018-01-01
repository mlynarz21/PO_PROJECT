package com.StoreX.service.impl.ZamowienieServicesImpl;

import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.persistence.repository.ZamowienieRepository.ZamowienieZakupuRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.ZamowienieServices.ZamowienieZakupuUpdateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

@Service
public class ZamowienieZakupuUpdateServiceImpl implements ZamowienieZakupuUpdateService {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    ZamowienieZakupuRepository zamowienieZakupuRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateStatusZamowienia(String sessionId, Long ID) throws AuthenticationException {
        //  if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
        // throw new AuthenticationException();
        //  }

        getZamowienieZakupuRepository().updateStatusZamowienia(ID, StatusWydania.Gotowe.toString());
    }

    public ZamowienieZakupuRepository getZamowienieZakupuRepository() {
        return zamowienieZakupuRepository;
    }
}

package com.StoreX.service.impl.ZamowienieServicesImpl;

import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieZakupu;
import com.StoreX.persistence.repository.ZamowienieRepository.ZamowienieZakupuRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.ZamowienieServices.ZamowienieZakupuFindService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ZamowienieZakupuSearchServiceImpl implements ZamowienieZakupuFindService {

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

        List<ZamowienieZakupu> result = getZamowienieZakupuRepository().findByStatus(StatusWydania.Zaakceptowane.toString());
        List<ZamowienieZakupuBO> resultBO = new ArrayList<>();

        for (ZamowienieZakupu zamowienie : result) {
            resultBO.add(modelMapper.map(zamowienie, ZamowienieZakupuBO.class));
        }

        return resultBO;
    }

    public ZamowienieZakupuRepository getZamowienieZakupuRepository() {
        return zamowienieZakupuRepository;
    }
}

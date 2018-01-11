package com.StoreX.service.impl.UmieszczenieServicesImpl;

import com.StoreX.common.datatypes.bo.UmieszczenieBO;
import com.StoreX.persistence.entity.UmieszczenieEntities.Umieszczenie;
import com.StoreX.persistence.repository.UmieszczenieRepository.UmieszczenieRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.UmieszczenieServices.UmieszczenieSearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UmieszczenieSearchServiceImpl implements UmieszczenieSearchService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    UmieszczenieRepository umieszczenieRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UmieszczenieBO> findAllForTowar(String sessionId, Long ID)throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            // throw new AuthenticationException();
        }
        List<Umieszczenie> umieszczenieList = getUmieszczenieRepository().findAllForTowar(ID);

        List<UmieszczenieBO> resultBO = new ArrayList<>();

        for (Umieszczenie umieszczenie : umieszczenieList) {
            resultBO.add(modelMapper.map(umieszczenie, UmieszczenieBO.class));
        }

        return resultBO;

    }

    public UmieszczenieRepository getUmieszczenieRepository() {
        return umieszczenieRepository;
    }
}

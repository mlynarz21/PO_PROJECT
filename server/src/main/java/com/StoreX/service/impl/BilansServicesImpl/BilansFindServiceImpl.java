package com.StoreX.service.impl.BilansServicesImpl;

import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.repository.BilansRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.BilansServices.BilansFindService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.UUID;
@Service
public class BilansFindServiceImpl implements BilansFindService {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    BilansRepository bilansRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public BilansBO findLast(String sessionId)throws AuthenticationException {
        if (!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            //throw new AuthenticationException();
        }
        Bilans lastBilans = getBilansRepository().findLastBilansByDate();

        if (lastBilans != null)
            return modelMapper.map(lastBilans, BilansBO.class);
        else return null;
    }


    public BilansRepository getBilansRepository() {
        return bilansRepository;
    }
}

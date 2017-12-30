package com.StoreX.service.impl.BilansServicesImpl;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.service.BilansServices.PozycjaBilansuFindService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaBilansuFindServiceImpl implements PozycjaBilansuFindService {

    @Autowired
    PozycjaBilansuRepository pozycjaBilansuRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<PozycjaBilansuBO> findAllForBilans(Long id) throws AuthenticationException{

        //if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
        // throw new AuthenticationException();
        //}
        List<PozycjaBilansu> pozycjaBilansuList = getPozycjaBilansuRepository().findAllForBilans(id);
        List<PozycjaBilansuBO> resultBO = new ArrayList<>();

        for (PozycjaBilansu pozycjaBilansu : pozycjaBilansuList) {
            resultBO.add(modelMapper.map(pozycjaBilansu, PozycjaBilansuBO.class));
        }

        return resultBO;
    }

    public PozycjaBilansuRepository getPozycjaBilansuRepository() {
        return pozycjaBilansuRepository;
    }
}

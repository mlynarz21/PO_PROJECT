package com.StoreX.service.impl.ZamowienieServicesImpl;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.persistence.entity.ZamowienieEntities.PozycjaZamowienia;
import com.StoreX.persistence.repository.ZamowienieRepository.PozycjaZamowieniaRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.ZamowienieServices.PozycjaZamowieniaSearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PozycjaZamowieniaSearchServiceImpl implements PozycjaZamowieniaSearchService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    PozycjaZamowieniaRepository pozycjaZamowieniaRepository;

    private ModelMapper modelMapper = new ModelMapper();


    //todo add sessionId
    @Override
    public List<PozycjaZamowieniaBO> findAllforZamowienie(String sessionId, Long ID) throws AuthenticationException{
        //if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
        // throw new AuthenticationException();
        //}
        List<PozycjaZamowienia> pozycjaZamowieniaList = getPozycjaZamowieniaRepository().findAllForZamowienie(ID);
        List<PozycjaZamowieniaBO> resultBO = new ArrayList<>();

        for (PozycjaZamowienia pozycjaZamowienia : pozycjaZamowieniaList) {
            resultBO.add(modelMapper.map(pozycjaZamowienia, PozycjaZamowieniaBO.class));
        }

        return resultBO;
    }

    public PozycjaZamowieniaRepository getPozycjaZamowieniaRepository() {
        return pozycjaZamowieniaRepository;
    }

}

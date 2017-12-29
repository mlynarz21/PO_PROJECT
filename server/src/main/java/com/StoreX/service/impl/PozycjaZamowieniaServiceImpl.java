package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.ZamowienieBO;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.StoreX.persistence.entity.Umieszczenie;
import com.StoreX.persistence.entity.ZamowienieZakupu;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.persistence.repository.PozycjaZamowieniaRepository;
import com.StoreX.persistence.repository.UmieszczenieRepository;
import com.StoreX.service.AuthorizationService;
import com.StoreX.service.PozycjaZamowieniaService;
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
public class PozycjaZamowieniaServiceImpl implements PozycjaZamowieniaService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    PozycjaZamowieniaRepository pozycjaZamowieniaRepository;
    @Autowired
    UmieszczenieRepository umieszczenieRepository;

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

    //todo add alternative threads, check transactional
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public boolean ProceedPozycjaZamowienia(String sessionId, Long idPozycji, Long idUmieszczenia, double iloscRealizowana) throws AuthenticationException, Exception{

        //if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            // throw new AuthenticationException();
        //}

        String type = getPozycjaZamowieniaRepository().getType(idPozycji);
        if(!type.equalsIgnoreCase("zamowieniezakupu"))
            return false;
        PozycjaZamowienia pozycjaZamowienia = getPozycjaZamowieniaRepository().findOne(idPozycji);
        Umieszczenie umieszczenie = getUmieszczenieRepository().findOne(idUmieszczenia);
        double iloscJuzZrealizowana = pozycjaZamowienia.getZrealizowano();
        double iloscAktualnaUmieszczenia = umieszczenie.getIloscWLokalizacji();
        double iloscCalkowita = pozycjaZamowienia.getIlosc();

        /*
        Scenariusz alternatywny
         */
        if(iloscJuzZrealizowana + iloscRealizowana > iloscCalkowita)
            throw new Exception("Podano za duzą ilosc");
        if(iloscAktualnaUmieszczenia - iloscRealizowana < 0)
            throw new Exception("Podano za duzą ilosc Nie ma tyle w lokalizacji");

        getPozycjaZamowieniaRepository().realizacjaPozycjiZmowienia(idPozycji, iloscJuzZrealizowana + iloscRealizowana);
        getUmieszczenieRepository().realizacjaPozycjiZmowienia(idUmieszczenia, iloscAktualnaUmieszczenia - iloscRealizowana);

        if(iloscAktualnaUmieszczenia - iloscRealizowana == 0)
        {
            getUmieszczenieRepository().delete(idUmieszczenia);
        }

        return true;

    }

    @Override
    public void add(PozycjaZamowienia pozycjaZamowienia) {
        getPozycjaZamowieniaRepository().save(pozycjaZamowienia);
    }

    public PozycjaZamowieniaRepository getPozycjaZamowieniaRepository() {
        return pozycjaZamowieniaRepository;
    }
    public UmieszczenieRepository getUmieszczenieRepository() {
        return umieszczenieRepository;
    }
}

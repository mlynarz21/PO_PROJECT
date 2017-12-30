package com.StoreX.service.impl.ZamowienieServicesImpl;

import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.StoreX.persistence.entity.Umieszczenie;
import com.StoreX.persistence.repository.PozycjaZamowieniaRepository;
import com.StoreX.persistence.repository.UmieszczenieRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.ZamowienieServices.PozycjaZamowieniaProceedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

@Service
public class PozycjaZamowieniaProceedServiceImpl implements PozycjaZamowieniaProceedService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    PozycjaZamowieniaRepository pozycjaZamowieniaRepository;
    @Autowired
    UmieszczenieRepository umieszczenieRepository;


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


    public PozycjaZamowieniaRepository getPozycjaZamowieniaRepository() {
        return pozycjaZamowieniaRepository;
    }
    public UmieszczenieRepository getUmieszczenieRepository() {
        return umieszczenieRepository;
    }
}

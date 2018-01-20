package com.StoreX.service.impl.BilansServicesImpl;

import com.StoreX.common.datatypes.bo.*;
import com.StoreX.persistence.entity.BilansEntities.Bilans;
import com.StoreX.persistence.entity.TowarEntities.Towar;
import com.StoreX.persistence.repository.BilansRepository.BilansRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.BilansServices.BilansCreationService;
import com.StoreX.service.BilansServices.PozycjaBilansuSearchService;
import com.StoreX.service.BilansServices.PozycjaBilansuCreationService;
import com.StoreX.service.HelperServices.TowarService;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaPrzyjeciaSearchService;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaWydaniaSearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.*;

@Service
public class BilansCreationServiceImpl implements BilansCreationService {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    PozycjaBilansuSearchService pozycjaBilansuSearchService;
    @Autowired
    PozycjaBilansuCreationService pozycjaBilansuCreationService;

    @Autowired
    PozycjaWydaniaSearchService pozycjaWydaniaSearchService;


    @Autowired
    PozycjaPrzyjeciaSearchService pozycjaPrzyjeciaSearchService;
    @Autowired
    TowarService towarService;


    @Autowired
    BilansRepository bilansRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public boolean addBilans(String sessionId, Date dataBilansowana)throws AuthenticationException , Exception{
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
        }

        int numberOfBilansesWithGivenDate = getBilansRepository().findBilansForMonthAndYear(dataBilansowana.getMonth() + 1, dataBilansowana.getYear() + 1900);
        if(numberOfBilansesWithGivenDate > 0)
            throw new Exception("BIlans już istnieje");

        Map<Long,Double> pozycjeDoBilansu = new HashMap<>();

        Bilans nowyBilans = new Bilans();
        nowyBilans.setDataBilansu(dataBilansowana);
        nowyBilans.setDataWykonania(new Date());

        Bilans lastBilans = bilansRepository.findLastBilansByDate();

        bilansRepository.save(nowyBilans);
        BilansBO nowyBilansBO = modelMapper.map(nowyBilans,BilansBO.class);


        if(lastBilans != null)
        {
            BilansBO lastBilansBO = modelMapper.map(lastBilans, BilansBO.class);
            Long latBilansBOId = lastBilansBO.getID();
            List<PozycjaBilansuBO> pozycjaBilansuBOList =  pozycjaBilansuSearchService.findAllForBilans(latBilansBOId);
            for (PozycjaBilansuBO pozycjaBilansuBO: pozycjaBilansuBOList) {
                pozycjeDoBilansu.put(pozycjaBilansuBO.getTowar().getID(), pozycjaBilansuBO.getIlosc());
            }
        }

        int newMonth = dataBilansowana.getMonth() + 1  == 13 ? 1 : dataBilansowana.getMonth() + 1 ;
        int newYear = newMonth == 1 ? dataBilansowana.getYear() + 1901 : dataBilansowana.getYear() + 1900;

        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<>();

        pozycjaPrzyjeciaBOList = pozycjaPrzyjeciaSearchService.findAllForMonthAndYear(newMonth, newYear);

        for (PozycjaPrzyjeciaBO pozycjaPrzyjeciaBO: pozycjaPrzyjeciaBOList) {
            if(pozycjeDoBilansu.containsKey(pozycjaPrzyjeciaBO.getTowar().getID()))
                pozycjeDoBilansu.put(pozycjaPrzyjeciaBO.getTowar().getID(), pozycjeDoBilansu.get(pozycjaPrzyjeciaBO.getTowar().getID()) + pozycjaPrzyjeciaBO.getIlosc());
            else
                pozycjeDoBilansu.put(pozycjaPrzyjeciaBO.getTowar().getID(), pozycjaPrzyjeciaBO.getIlosc());
        }
        List<PozycjaWydaniaBO> pozycjaWydaniaBOList = new ArrayList<>();

        pozycjaWydaniaBOList = pozycjaWydaniaSearchService.findAllForMonthAndYear(newMonth, newYear);

        for (PozycjaWydaniaBO pozycjaWydaniaBO: pozycjaWydaniaBOList) {
            if(pozycjeDoBilansu.containsKey(pozycjaWydaniaBO.getTowar().getID()))
                pozycjeDoBilansu.put(pozycjaWydaniaBO.getTowar().getID(), pozycjeDoBilansu.get(pozycjaWydaniaBO.getTowar().getID()) - pozycjaWydaniaBO.getIlosc());
            else
                //todo: posiible?
                pozycjeDoBilansu.put(pozycjaWydaniaBO.getTowar().getID(), -pozycjaWydaniaBO.getIlosc());
        }

        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<>();

        for (Map.Entry<Long,Double> entry :pozycjeDoBilansu.entrySet()) {
            Long idTowaru = entry.getKey();
            Towar t = towarService.getById(idTowaru);
            TowarBO towar = modelMapper.map(t, TowarBO.class);
            double ilosc = entry.getValue();
            PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
            pozycjaBilansuBO.setBilans(nowyBilansBO);
            pozycjaBilansuBO.setTowar(towar);
            pozycjaBilansuBO.setIlosc(ilosc);

            pozycjaBilansuBOList.add(pozycjaBilansuBO);
        }

        for (PozycjaBilansuBO pozycjaBilansuBo: pozycjaBilansuBOList) {
            pozycjaBilansuCreationService.savePozycjaBilansu(pozycjaBilansuBo);
        }

        return true;
    }

    public BilansRepository getBilansRepository() {
        return bilansRepository;
    }
}

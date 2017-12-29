package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.*;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.repository.BilansRepository;
import com.StoreX.service.*;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.*;

@Service
public class BilansServiceImplementation implements BilansService {


    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    PozycjaBilansuService pozycjaBilansuService;

    @Autowired
    PozycjaWydaniaService pozycjaWydaniaService;

    @Autowired
    PozycjaPrzyjeciaService pozycjaPrzyjeciaService;


    @Autowired
    BilansRepository bilansRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public boolean addBilans(String sessionId, Date dataBilansowana)throws AuthenticationException , Exception{
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
           // throw new AuthenticationException();
        }

        int numberOfBilansesWithGivenDate = getBilansRepository().findBilansForMonthAndYear(dataBilansowana.getMonth() + 1, dataBilansowana.getYear() + 1900);
       // if(numberOfBilansesWithGivenDate > 0)
       //     throw new Exception("BIlans już istnieje");

        Map<TowarBO,Double> pozycjeDoBilansu = new HashMap<TowarBO, Double>();

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
            List<PozycjaBilansuBO> pozycjaBilansuBOList =  pozycjaBilansuService.findAllForBilans(latBilansBOId);
            for (PozycjaBilansuBO pozycjaBilansuBO: pozycjaBilansuBOList) {
                pozycjeDoBilansu.put(pozycjaBilansuBO.getTowar(), pozycjaBilansuBO.getIlosc());
            }
        }

        int newMonth = dataBilansowana.getMonth() + 1  == 13 ? 1 : dataBilansowana.getMonth() + 1 ;
        int newYear = newMonth == 1 ? dataBilansowana.getYear() + 1901 : dataBilansowana.getYear() + 1900;

        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<>();

            pozycjaPrzyjeciaBOList = pozycjaPrzyjeciaService.findAllForMonthAndYear(newMonth, newYear);

        for (PozycjaPrzyjeciaBO pozycjaPrzyjeciaBO: pozycjaPrzyjeciaBOList) {
            if(pozycjeDoBilansu.containsKey(pozycjaPrzyjeciaBO.getTowar()))
                pozycjeDoBilansu.put(pozycjaPrzyjeciaBO.getTowar(), pozycjeDoBilansu.get(pozycjaPrzyjeciaBO.getTowar()) + pozycjaPrzyjeciaBO.getIlosc());
            else
                pozycjeDoBilansu.put(pozycjaPrzyjeciaBO.getTowar(), pozycjaPrzyjeciaBO.getIlosc());
        }
        List<PozycjaWydaniaBO> pozycjaWydaniaBOList = new ArrayList<>();

             pozycjaWydaniaBOList = pozycjaWydaniaService.findAllForMonthAndYear(newMonth, newYear);

        for (PozycjaWydaniaBO pozycjaWydaniaBO: pozycjaWydaniaBOList) {
            if(pozycjeDoBilansu.containsKey(pozycjaWydaniaBO.getTowar()))
                pozycjeDoBilansu.put(pozycjaWydaniaBO.getTowar(), pozycjeDoBilansu.get(pozycjaWydaniaBO.getTowar()) - pozycjaWydaniaBO.getIlosc());
            else
                //todo: posiible?
                pozycjeDoBilansu.put(pozycjaWydaniaBO.getTowar(), -pozycjaWydaniaBO.getIlosc());
        }

        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<>();

        for (Map.Entry<TowarBO,Double> entry :pozycjeDoBilansu.entrySet()) {
            TowarBO towar = entry.getKey();
            double ilosc = entry.getValue();
            PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
            pozycjaBilansuBO.setBilans(nowyBilansBO);
            pozycjaBilansuBO.setTowar(towar);
            pozycjaBilansuBO.setIlosc(ilosc);

            pozycjaBilansuBOList.add(pozycjaBilansuBO);
        }

        for (PozycjaBilansuBO pozycjaBilansuBo: pozycjaBilansuBOList) {
            PozycjaBilansu pozycjaBilansu = modelMapper.map(pozycjaBilansuBo, PozycjaBilansu.class);
            pozycjaBilansuService.savePozycjaBilansu(pozycjaBilansu);
        }

    return true;
    }


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

    @Override
    public void saveBilans(Bilans b2) {
        getBilansRepository().save(b2);
    }

    public BilansRepository getBilansRepository() {
        return bilansRepository;
    }
}

package com.StoreX.service.impl.BilansServicesImpl;

import com.StoreX.common.datatypes.bo.*;
import com.StoreX.persistence.entity.BilansEntities.Bilans;
import com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu;
import com.StoreX.persistence.entity.TowarEntities.Towar;
import com.StoreX.persistence.repository.BilansRepository.BilansRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.BilansServices.PozycjaBilansuCreationService;
import com.StoreX.service.BilansServices.PozycjaBilansuSearchService;
import com.StoreX.service.HelperServices.TowarService;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaPrzyjeciaSearchService;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaWydaniaSearchService;
import org.hamcrest.core.AnyOf;
import org.hibernate.mapping.Any;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BilansCreationServiceImplTest {

    @Mock
    private AuthorizationService authorizationService;
    @Mock
    PozycjaBilansuSearchService pozycjaBilansuSearchService;
    @Mock
    PozycjaBilansuCreationService pozycjaBilansuCreationService;
    @Mock
    PozycjaWydaniaSearchService pozycjaWydaniaSearchService;
    @Mock
    PozycjaPrzyjeciaSearchService pozycjaPrzyjeciaSearchService;
    @Mock
    TowarService towarService;
    @Mock
    BilansRepository bilansRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    BilansCreationServiceImpl bilansCreationService;

    @Before
    public void setUp() throws Exception {
        Calendar dataBilansowana = Calendar.getInstance();
        dataBilansowana.set(2017,10,10);

        Calendar dataWykonania1 = Calendar.getInstance();
        dataWykonania1.set(2017,10,10);
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017,9,10);
        Bilans lastBilans = new Bilans(1L,dataBilansowana.getTime(),dataOstatniegoBilansu.getTime() );

        Mockito.when(authorizationService.isUserAuthorized(UUID.fromString("53b37a38-7bf1-48dd-9b92-f14e1b691adf"))).thenReturn(true);
    }

    /**
     * Jeżeli próbujemy dodać bilans dla już zbilansowanego miesiąca, operacja nie zostaje wykonana i zostaje rzucony wyjątek
     */
    @Test
    public void addBilans_BilansAlreadyExist_AreEqual() {
        //arrange
        //+1, ze względu na indeksowanie od 0 przy ustalaniu daty
        Mockito.when(bilansRepository.findBilansForMonthAndYear(9 + 1,2017)).thenReturn(1);
        Calendar dataBilansowana = Calendar.getInstance();
        dataBilansowana.set(2017,9,10);
        String errorMessage = "";

        //act
        try {
            bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Assert.assertEquals("BIlans już istnieje", errorMessage);

    }

    /**
     * Dodaje nowy bilans z pozyjcą z ilością równą ilości w poprzednim bilansie
     */
    @Test
    public void addBilans_PozycjeOstatniegoBilansu_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017,9,10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017,10,10);
        Bilans ostatniBilans = new Bilans(1L,dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);

        TowarBO t = new TowarBO();
        t.setID(1L);

        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);

        PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
        pozycjaBilansuBO.setIlosc(10);
        pozycjaBilansuBO.setTowar(t);
        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<PozycjaBilansuBO>();
        pozycjaBilansuBOList.add(pozycjaBilansuBO);
        try {
            Mockito.when(pozycjaBilansuSearchService.findAllForBilans(1L)).thenReturn(pozycjaBilansuBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        dataBilansowana.set(2017,10,10);
        String errorMessage = "";

        //act
        try {
            bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService).savePozycjaBilansu(argument.capture());
        Assert.assertEquals((int)10.0, (int)argument.getValue().getIlosc());
    }


    /**
     * Dodaje nowy bilans z pozyjcą z ilością równą ilości w poprzednim bilansie plus ilosca z pozycji przyjec
     */
    @Test
    public void addBilans_PozycjeOstatniegoBilansuPozycjePrzyjec_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017,9,10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017,10,10);
        Bilans ostatniBilans = new Bilans(1L,dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);
        TowarBO t = new TowarBO();
        t.setID(1L);
        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);

        PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
        pozycjaBilansuBO.setIlosc(10);
        pozycjaBilansuBO.setTowar(t);
        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<PozycjaBilansuBO>();
        pozycjaBilansuBOList.add(pozycjaBilansuBO);
        try {
            Mockito.when(pozycjaBilansuSearchService.findAllForBilans(1L)).thenReturn(pozycjaBilansuBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        PozycjaPrzyjeciaBO pozycjaPrzyjeciaBO = new PozycjaPrzyjeciaBO();
        pozycjaPrzyjeciaBO.setTowar(t);
        pozycjaPrzyjeciaBO.setID(1L);
        pozycjaPrzyjeciaBO.setIlosc(20);
        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<PozycjaPrzyjeciaBO>();
        pozycjaPrzyjeciaBOList.add(pozycjaPrzyjeciaBO);
        try {
            Mockito.when(pozycjaPrzyjeciaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaPrzyjeciaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        dataBilansowana.set(2017,10,10);
        String errorMessage = "";

        //act
        try {
            bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService).savePozycjaBilansu(argument.capture());
        Assert.assertEquals((int)30.0, (int)argument.getValue().getIlosc());
    }

    /**
     * Dodaje nowy bilans z pozyjcą z ilością równą ilości w poprzednim bilansie plus ilosca z pozycji przyjec oraz
     * odjeta iloscia w pozycji wydania
     */
    @Test
    public void addBilans_PozycjeOstatniegoBilansuPozycjePrzyjecPozycjeWydan_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017,9,10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017,10,10);
        Bilans ostatniBilans = new Bilans(1L,dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);
        TowarBO t = new TowarBO();
        t.setID(1L);
        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);

        PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
        pozycjaBilansuBO.setIlosc(10);
        pozycjaBilansuBO.setTowar(t);
        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<PozycjaBilansuBO>();
        pozycjaBilansuBOList.add(pozycjaBilansuBO);
        try {
            Mockito.when(pozycjaBilansuSearchService.findAllForBilans(1L)).thenReturn(pozycjaBilansuBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        PozycjaPrzyjeciaBO pozycjaPrzyjeciaBO = new PozycjaPrzyjeciaBO();
        pozycjaPrzyjeciaBO.setTowar(t);
        pozycjaPrzyjeciaBO.setID(1L);
        pozycjaPrzyjeciaBO.setIlosc(20);
        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<PozycjaPrzyjeciaBO>();
        pozycjaPrzyjeciaBOList.add(pozycjaPrzyjeciaBO);
        try {
            Mockito.when(pozycjaPrzyjeciaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaPrzyjeciaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        PozycjaWydaniaBO pozycjaWydaniaaBO = new PozycjaWydaniaBO();
        pozycjaWydaniaaBO.setTowar(t);
        pozycjaWydaniaaBO.setID(1L);
        pozycjaWydaniaaBO.setIlosc(5);
        List<PozycjaWydaniaBO> pozycjaWydaniaBOList = new ArrayList<PozycjaWydaniaBO>();
        pozycjaWydaniaBOList.add(pozycjaWydaniaaBO);
        try {
            Mockito.when(pozycjaWydaniaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaWydaniaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        dataBilansowana.set(2017,10,10);
        String errorMessage = "";

        //act
        try {
            bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService).savePozycjaBilansu(argument.capture());
        Assert.assertEquals((int)25.0, (int)argument.getValue().getIlosc());
    }

}
package com.StoreX.service.impl.BilansServicesImpl;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;
import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;
import com.StoreX.common.datatypes.bo.PozycjaWydaniaBO;
import com.StoreX.common.datatypes.bo.TowarBO;
import com.StoreX.persistence.entity.BilansEntities.Bilans;
import com.StoreX.persistence.entity.TowarEntities.Towar;
import com.StoreX.persistence.repository.BilansRepository.BilansRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import com.StoreX.service.BilansServices.PozycjaBilansuCreationService;
import com.StoreX.service.BilansServices.PozycjaBilansuSearchService;
import com.StoreX.service.HelperServices.TowarService;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaPrzyjeciaSearchService;
import com.StoreX.service.PozycjeWydanPrzyjecServices.PozycjaWydaniaSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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


        Mockito.when(authorizationService.isUserAuthorized(UUID.fromString("53b37a38-7bf1-48dd-9b92-f14e1b691adf"))).thenReturn(true);
    }

    /**
     * Jeżeli próbujemy dodać bilans dla już zbilansowanego miesiąca, operacja nie zostaje wykonana i zostaje rzucony wyjątek
     */
    @Test
    public void addBilans_BilansAlreadyExist_AreEqual() {
        //arrange
        //+1, ze względu na indeksowanie od 0 przy ustalaniu daty
        Mockito.when(bilansRepository.findBilansForMonthAndYear(9 + 1, 2017)).thenReturn(1);
        Calendar dataBilansowana = Calendar.getInstance();
        dataBilansowana.set(2017, 9, 10);
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
     * Istnieje bilans bez pozycji bilansu dla miesiąca 10-2017
     * Dla kolejnego bilansowanego miesiaca nie ma pozycji wydan i przyjec
     * Wewnątrz metody add bilans jeden raz zostaje wywolane metoda repozytorium zapisująca bilans dla miesiąca 11-2017
     * oraz 0 razy metoda serwisowa zapisujaca pozyce bilansu
     */
    @Test
    public void addBilans_BrakPozycjiBilansu_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017, 9, 10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017, 11, 10);
        Bilans ostatniBilans = new Bilans(1L, dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);

        TowarBO t = new TowarBO();
        t.setID(1L);

        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);



        Calendar dataBilansowana = Calendar.getInstance();
        //parametr miesiaca dla bilansowanej daty jest rowny 10, ze wzgledu na indeksowanie od 0
        dataBilansowana.set(2017, 10, 10);
        String errorMessage = "";
        boolean sukces = false;

        //act
        try {
            sukces =  bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Calendar dataBilansu = Calendar.getInstance();
        dataBilansu.set(2017, 10, 10);
        verify(pozycjaBilansuCreationService, Mockito.times(0)).savePozycjaBilansu(any());


        verify(bilansRepository, Mockito.times(1)).save(Matchers.<Bilans>any());
        ArgumentCaptor<Bilans> argument2 = ArgumentCaptor.forClass(Bilans.class);
        verify(bilansRepository).save(argument2.capture());
        Assert.assertEquals(dataBilansu.getTime().getMonth(), argument2.getValue().getDataBilansu().getMonth());
        Assert.assertEquals(dataBilansu.getTime().getYear(), argument2.getValue().getDataBilansu().getYear());

        Assert.assertTrue(sukces);
    }

    /**
     * Istnieje bilans  jedną pozycją bilansu z ilocią 10 dla miesiąca 10-2017
     * Dla kolejnego bilansowanego miesiaca nie ma pozycji wydan i przyjec
     * Wewnątrz metody add bilans jeden raz zostaje wywolane metoda repozytorium zapisująca bilans dla miesiąca 11-2017
     * oraz jeden raz metoda serwisowa zapisujaca pozyce bilansu z iloscią 10
     */
    @Test
    public void addBilans_PozycjeOstatniegoBilansu_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017, 9, 10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017, 11, 10);
        Bilans ostatniBilans = new Bilans(1L, dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);

        TowarBO t = new TowarBO();
        t.setID(1L);

        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);

        PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
        pozycjaBilansuBO.setIlosc(10);
        pozycjaBilansuBO.setTowar(t);
        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<>();
        pozycjaBilansuBOList.add(pozycjaBilansuBO);
        try {
            Mockito.when(pozycjaBilansuSearchService.findAllForBilans(1L)).thenReturn(pozycjaBilansuBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        //parametr miesiaca dla bilansowanej daty jest rowny 10, ze wzgledu na indeksowanie od 0
        dataBilansowana.set(2017, 10, 10);
        String errorMessage = "";
        boolean sukces = false;

        //act
        try {
           sukces =  bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Calendar dataBilansu = Calendar.getInstance();
        dataBilansu.set(2017, 10, 10);
        verify(pozycjaBilansuCreationService, Mockito.times(1)).savePozycjaBilansu(any());
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService).savePozycjaBilansu(argument.capture());
        Assert.assertEquals((int) 10.0, (int) argument.getValue().getIlosc());

        verify(bilansRepository, Mockito.times(1)).save(Matchers.<Bilans>any());
        ArgumentCaptor<Bilans> argument2 = ArgumentCaptor.forClass(Bilans.class);
        verify(bilansRepository).save(argument2.capture());
        Assert.assertEquals(dataBilansu.getTime().getMonth(), argument2.getValue().getDataBilansu().getMonth());
        Assert.assertEquals(dataBilansu.getTime().getYear(), argument2.getValue().getDataBilansu().getYear());

        Assert.assertTrue(sukces);
    }


    /**
     * Istnieje bilans  jedną pozycją bilansu z ilocią 10 dla miesiąca 10-2017
     * Dla kolejnego bilansowanego miesiaca istnieje jedna pozycja przyjcia z iloscia 20 dla tego samego towaru, co
     * w pozycji bilasnu
     * Wewnątrz metody add bilans jeden raz zostaje wywolane metoda repozytorium zapisująca bilans dla miesiąca 11-2017
     * oraz jeden raz metoda serwisowa zapisujaca pozyce bilansu z iloscią 30
     */
    @Test
    public void addBilans_PozycjeOstatniegoBilansuPozycjePrzyjec_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017, 9, 10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017, 10, 10);
        Bilans ostatniBilans = new Bilans(1L, dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);
        TowarBO t = new TowarBO();
        t.setID(1L);
        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);

        PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
        pozycjaBilansuBO.setIlosc(10);
        pozycjaBilansuBO.setTowar(t);
        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<>();
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
        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<>();
        pozycjaPrzyjeciaBOList.add(pozycjaPrzyjeciaBO);
        try {
            Mockito.when(pozycjaPrzyjeciaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaPrzyjeciaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        //parametr miesiaca dla bilansowanej daty jest rowny 10, ze wzgledu na indeksowanie od 0
        dataBilansowana.set(2017, 10, 10);
        String errorMessage = "";
        boolean sukces = false;

        //act
        try {
            sukces = bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Calendar dataBilansu = Calendar.getInstance();
        dataBilansu.set(2017, 10, 10);
        verify(pozycjaBilansuCreationService, Mockito.times(1)).savePozycjaBilansu(any());
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService).savePozycjaBilansu(argument.capture());
        Assert.assertEquals((int) 30.0, (int) argument.getValue().getIlosc());

        verify(bilansRepository, Mockito.times(1)).save(Matchers.<Bilans>any());
        ArgumentCaptor<Bilans> argument2 = ArgumentCaptor.forClass(Bilans.class);
        verify(bilansRepository).save(argument2.capture());
        Assert.assertEquals(dataBilansu.getTime().getMonth(), argument2.getValue().getDataBilansu().getMonth());
        Assert.assertEquals(dataBilansu.getTime().getYear(), argument2.getValue().getDataBilansu().getYear());

        Assert.assertTrue(sukces);
    }

    /**
     * Istnieje bilans  jedną pozycją bilansu z ilocią 10 dla miesiąca 10-2017
     * Dla kolejnego bilansowanego miesiaca istnieje jedna pozycja przyjcia z iloscia 20 dla tego samego towaru, co
     * w pozycji bilasnu
     * Dla kolejnego bilansowanego miesiaca istnieje jedna pozycja wydania z iloscia 5 dla tego samego towaru, co
     * w pozycji bilasnu
     * Wewnątrz metody add bilans jeden raz zostaje wywolane metoda repozytorium zapisująca bilans dla miesiąca 11-2017
     * oraz jeden raz metoda serwisowa zapisujaca pozyce bilansu z iloscią 25
     */
    @Test
    public void addBilans_PozycjeOstatniegoBilansuPozycjePrzyjecPozycjeWydan_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017, 9, 10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017, 10, 10);
        Bilans ostatniBilans = new Bilans(1L, dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);
        TowarBO t = new TowarBO();
        t.setID(1L);
        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);

        PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
        pozycjaBilansuBO.setIlosc(10);
        pozycjaBilansuBO.setTowar(t);
        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<>();
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
        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<>();
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
        List<PozycjaWydaniaBO> pozycjaWydaniaBOList = new ArrayList<>();
        pozycjaWydaniaBOList.add(pozycjaWydaniaaBO);
        try {
            Mockito.when(pozycjaWydaniaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaWydaniaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        //parametr miesiaca dla bilansowanej daty jest rowny 10, ze wzgledu na indeksowanie od 0
        dataBilansowana.set(2017, 10, 10);
        String errorMessage = "";
        boolean sukces = false;

        //act
        try {
            sukces = bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Calendar dataBilansu = Calendar.getInstance();
        dataBilansu.set(2017, 10, 10);
        verify(pozycjaBilansuCreationService, Mockito.times(1)).savePozycjaBilansu(any());
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService).savePozycjaBilansu(argument.capture());
        Assert.assertEquals((int) 25.0, (int) argument.getValue().getIlosc());

        verify(bilansRepository, Mockito.times(1)).save(Matchers.<Bilans>any());
        ArgumentCaptor<Bilans> argument2 = ArgumentCaptor.forClass(Bilans.class);
        verify(bilansRepository).save(argument2.capture());
        Assert.assertEquals(dataBilansu.getTime().getMonth(), argument2.getValue().getDataBilansu().getMonth());
        Assert.assertEquals(dataBilansu.getTime().getYear(), argument2.getValue().getDataBilansu().getYear());

        Assert.assertTrue(sukces);
    }


    /**
     * Istnieje bilans  jedną pozycją bilansu z ilocią 10 dla miesiąca 10-2017
     * Dla kolejnego bilansowanego miesiaca istnieje jedna pozycja przyjcia z iloscia 20 dla innego  towaru, niż
     * w pozycji bilasnu
     * Dla kolejnego bilansowanego miesiaca istnieje jedna pozycja wydania z iloscia 5 dla innego towaru, niż
     * w pozycji bilasnu i pozycji przyjecia
     * Wewnątrz metody add bilans jeden raz zostaje wywolane metoda repozytorium zapisująca bilans dla miesiąca 11-2017
     * oraz jtrzy razy metoda serwisowa zapisujaca pozyce bilansu
     */
    @Test
    public void addBilans_PozycjeOstatniegoBilansuPozycjePrzyjecPozycjeWydanRozneTowary_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017, 9, 10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017, 10, 10);
        Bilans ostatniBilans = new Bilans(1L, dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(ostatniBilans);
        TowarBO t = new TowarBO();
        t.setID(1L);
        Towar t11 = new Towar();
        t11.setID(1L);
        TowarBO t2 = new TowarBO();
        t2.setID(2L);
        Towar t22 = new Towar();
        t22.setID(2L);
        TowarBO t3 = new TowarBO();
        t3.setID(3L);
        Towar t33 = new Towar();
        t33.setID(3L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);
        Mockito.when(towarService.getById(2L)).thenReturn(t22);
        Mockito.when(towarService.getById(3L)).thenReturn(t33);

        PozycjaBilansuBO pozycjaBilansuBO = new PozycjaBilansuBO();
        pozycjaBilansuBO.setIlosc(10);
        pozycjaBilansuBO.setTowar(t);
        List<PozycjaBilansuBO> pozycjaBilansuBOList = new ArrayList<>();
        pozycjaBilansuBOList.add(pozycjaBilansuBO);
        try {
            Mockito.when(pozycjaBilansuSearchService.findAllForBilans(1L)).thenReturn(pozycjaBilansuBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        PozycjaPrzyjeciaBO pozycjaPrzyjeciaBO = new PozycjaPrzyjeciaBO();
        pozycjaPrzyjeciaBO.setTowar(t2);
        pozycjaPrzyjeciaBO.setID(2L);
        pozycjaPrzyjeciaBO.setIlosc(20);
        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<>();
        pozycjaPrzyjeciaBOList.add(pozycjaPrzyjeciaBO);
        try {
            Mockito.when(pozycjaPrzyjeciaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaPrzyjeciaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        PozycjaWydaniaBO pozycjaWydaniaaBO = new PozycjaWydaniaBO();
        pozycjaWydaniaaBO.setTowar(t3);
        pozycjaWydaniaaBO.setID(3L);
        pozycjaWydaniaaBO.setIlosc(5);
        List<PozycjaWydaniaBO> pozycjaWydaniaBOList = new ArrayList<>();
        pozycjaWydaniaBOList.add(pozycjaWydaniaaBO);
        try {
            Mockito.when(pozycjaWydaniaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaWydaniaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        //parametr miesiaca dla bilansowanej daty jest rowny 10, ze wzgledu na indeksowanie od 0
        dataBilansowana.set(2017, 10, 10);
        String errorMessage = "";
        boolean sukces = false;

        //act
        try {
            sukces = bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService, Mockito.times(3)).savePozycjaBilansu(any());

        Calendar dataBilansu = Calendar.getInstance();
        dataBilansu.set(2017, 10, 10);
        verify(bilansRepository, Mockito.times(1)).save(Matchers.<Bilans>any());
        ArgumentCaptor<Bilans> argument2 = ArgumentCaptor.forClass(Bilans.class);
        verify(bilansRepository).save(argument2.capture());
        Assert.assertEquals(dataBilansu.getTime().getMonth(), argument2.getValue().getDataBilansu().getMonth());
        Assert.assertEquals(dataBilansu.getTime().getYear(), argument2.getValue().getDataBilansu().getYear());

        Assert.assertTrue(sukces);

    }


    /**
     * W bazie nie istnieje bilans ani pozycje bilansu
     * Dla  bilansowanego miesiaca istnieje jedna pozycja przyjcia z iloscia 20
     * Dla  bilansowanego miesiaca istnieje jedna pozycja wydania z iloscia 5 dla tego samego towaru, co
     * w pozycji przyjecia
     * Wewnątrz metody add bilans jeden raz zostaje wywolane metoda repozytorium zapisująca bilans dla miesiąca 11-2017
     * oraz jeden raz metoda serwisowa zapisujaca pozyce bilansu z iloscią 15
     */
    @Test
    public void addBilans_PierwszyBilans_AreEqual() {
        Calendar dataOstatniegoBilansu = Calendar.getInstance();
        dataOstatniegoBilansu.set(2017, 9, 10);
        Calendar dataWykonaniaBilansu = Calendar.getInstance();
        dataWykonaniaBilansu.set(2017, 10, 10);
        Bilans ostatniBilans = new Bilans(1L, dataWykonaniaBilansu.getTime(), dataOstatniegoBilansu.getTime());
        Mockito.when(bilansRepository.findLastBilansByDate()).thenReturn(null);
        TowarBO t = new TowarBO();
        t.setID(1L);
        Towar t11 = new Towar();
        t11.setID(1L);

        Mockito.when(towarService.getById(1L)).thenReturn(t11);


        PozycjaPrzyjeciaBO pozycjaPrzyjeciaBO = new PozycjaPrzyjeciaBO();
        pozycjaPrzyjeciaBO.setTowar(t);
        pozycjaPrzyjeciaBO.setID(1L);
        pozycjaPrzyjeciaBO.setIlosc(20);
        List<PozycjaPrzyjeciaBO> pozycjaPrzyjeciaBOList = new ArrayList<>();
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
        List<PozycjaWydaniaBO> pozycjaWydaniaBOList = new ArrayList<>();
        pozycjaWydaniaBOList.add(pozycjaWydaniaaBO);
        try {
            Mockito.when(pozycjaWydaniaSearchService.findAllForMonthAndYear(11, 2017)).thenReturn(pozycjaWydaniaBOList);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Calendar dataBilansowana = Calendar.getInstance();
        //parametr miesiaca dla bilansowanej daty jest rowny 10, ze wzgledu na indeksowanie od 0
        dataBilansowana.set(2017, 10, 10);
        String errorMessage = "";
        boolean sukces = false;

        //act
        try {
            sukces = bilansCreationService.addBilans("53b37a38-7bf1-48dd-9b92-f14e1b691adf", dataBilansowana.getTime());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Calendar dataBilansu = Calendar.getInstance();
        dataBilansu.set(2017, 10, 10);
        verify(pozycjaBilansuCreationService, Mockito.times(1)).savePozycjaBilansu(any());
        ArgumentCaptor<PozycjaBilansuBO> argument = ArgumentCaptor.forClass(PozycjaBilansuBO.class);
        verify(pozycjaBilansuCreationService).savePozycjaBilansu(argument.capture());
        Assert.assertEquals((int) 15.0, (int) argument.getValue().getIlosc());

        verify(bilansRepository, Mockito.times(1)).save(Matchers.<Bilans>any());
        ArgumentCaptor<Bilans> argument2 = ArgumentCaptor.forClass(Bilans.class);
        verify(bilansRepository).save(argument2.capture());
        Assert.assertEquals(dataBilansu.getTime().getMonth(), argument2.getValue().getDataBilansu().getMonth());
        Assert.assertEquals(dataBilansu.getTime().getYear(), argument2.getValue().getDataBilansu().getYear());

        Assert.assertTrue(sukces);
    }
}
package com.StoreX.service.impl.ZamowienieServicesImpl;

import com.StoreX.persistence.entity.TowarEntities.Towar;
import com.StoreX.persistence.entity.UmieszczenieEntities.Lokalizacja;
import com.StoreX.persistence.entity.UmieszczenieEntities.Umieszczenie;
import com.StoreX.persistence.entity.ZamowienieEntities.PozycjaZamowienia;
import com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieZakupu;
import com.StoreX.persistence.repository.UmieszczenieRepository.UmieszczenieRepository;
import com.StoreX.persistence.repository.ZamowienieRepository.PozycjaZamowieniaRepository;
import com.StoreX.service.AuthorizationServices.AuthorizationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PozycjaZamowieniaProceedServiceImplTest {

    double IloswWUmieszczeniu1 = 100;
    double IloscWUmieszczeniu2 = 10;
    double IloscJuzZrealizowana = 0;
    @Mock
    UmieszczenieRepository umieszczenieRepository;

    @Mock
    PozycjaZamowieniaRepository pozycjaZamowieniaRepository;

    @Mock
    AuthorizationService authorizationService;

    @InjectMocks
    PozycjaZamowieniaProceedServiceImpl pozycjaZamowieniaProceedService;


    /**
     * W bazie istnieje towar t o ilostanie 200, zamowienie zakupu zz, pozycja zamowienia o ilosci 20 oraz ilosci juz zrealizowanej 0,
     * dla towaru t i zamwienia zakupu zz, 2 lokalizacje oraz 2 umieszczenia towaru t z ilosciami odpowiednio 10 i 100
     */
    @Before
    public void setUp() {
        Towar t = new Towar();
        t.setID(1L);
        t.setIlostan(200);
        ZamowienieZakupu zz = new ZamowienieZakupu();
        zz.setID(1L);
        PozycjaZamowienia pozycjaZamowienia = new PozycjaZamowienia(1L, 20, IloscJuzZrealizowana, t, zz);
        Mockito.when(pozycjaZamowieniaRepository.findOne(1L)).thenReturn(pozycjaZamowienia);
        Lokalizacja lokalizacja = new Lokalizacja();
        lokalizacja.setID(1L);
        Lokalizacja lokalizacja2 = new Lokalizacja();
        lokalizacja.setID(2L);
        Umieszczenie umieszczenie = new Umieszczenie(1L, IloswWUmieszczeniu1, t, lokalizacja);
        Mockito.when(umieszczenieRepository.findOne(1L)).thenReturn(umieszczenie);

        Umieszczenie umieszczenie2 = new Umieszczenie(2L, IloscWUmieszczeniu2, t, lokalizacja2);
        Mockito.when(umieszczenieRepository.findOne(2L)).thenReturn(umieszczenie2);

        Mockito.when(pozycjaZamowieniaRepository.findOne(4L)).thenReturn(null);
        Mockito.when(umieszczenieRepository.findOne(4L)).thenReturn(null);
        Mockito.when(authorizationService.isUserAuthorized(UUID.fromString("53b37a38-7bf1-48dd-9b92-f14e1b691adf"))).thenReturn(true);
    }


    /**
     * Ilos podana w parametrze metody realizacji pozycji zamowienia miesci się w przedziale 0 - ilość pozostala do zrealizowania
     * Operacja wykonana poprawnie, zwraca true.
     */
    @Test
    public void proceedPozycjaZamowienia_IloscWPrzedziale_IsTrue() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 10;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        Assert.assertTrue(sukces);
    }

    /**
     * Ilos podana w parametrze metody jest wieksza od ilości w pozycji zamowienia
     * Operacja niewykonana poprawnie, zostanie rzucony wyjątek.
     */
    @Test
    public void proceedPozycjaZamowienia_IloscZaDuza_ThrowsException() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 30;
        String errorMessage = "";

        //act
        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Assert.assertEquals(errorMessage, "Podano za duzą ilosc");
    }


    /**
     * Ilos podana w parametrze metody jest ujemna
     * Operacja niewykonana poprawnie, zostanie rzucony wyjątek.
     */
    @Test
    public void proceedPozycjaZamowienia_IloscUjemna_ThrowsException() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = -1;
        String errorMessage = "";

        //act

        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Assert.assertEquals(errorMessage, "Podana ilosc jest mniejsza od zera");
    }


    /**
     * WARUNEK BRZEGOWY
     * Ilosc podana w parametrze metody jest równa ilosci pozostaej do realizacji
     * Operacja zostanie wykonana poprawnie, zwróci true
     */
    @Test
    public void proceedPozycjaZamowienia_IloscRownaIlosciWZamowieni_IsTruue() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 20;
        boolean sukces = false;

        //act

        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        Assert.assertTrue(sukces);
    }

    /**
     * WARUNEK BRZEGOWY
     * Ilosc podana w parametrze jest równa 0
     * Operacja zostanie wykonana poprawnie, zwraca true
     */
    @Test
    public void proceedPozycjaZamowienia_IloscRowna0_IsTrue() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 0;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        Assert.assertTrue(sukces);
    }


    /**
     * Ilosc podana w parametrze metody jest wieksza niz w umieszczeniu
     *  Operacja niewykonana poprawnie, zostanie rzucony wyjątek.
     */
    @Test
    public void proceedPozycjaZamowienia_IloscWiekszaNizWUmieszczeniu_ThrowsException() {
        //arrange
        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 11;
        String errorMessage = "";

        //act
        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        //assert
        Assert.assertEquals("Podano za duzą ilosc Nie ma tyle w lokalizacji", errorMessage);
    }

    /**
     * WARUNEK BRZEGOWY
     * Ilosc podana w parametrze metody jest równa ilosci w Umieszczeniu
     * Operacja zostanie wykonana poprawnie, zwróci true
     */
    @Test
    public void proceedPozycjaZamowienia_IloscRownaIlosciWUmieszczeniu_IsTrue() {
        //arrange

        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 10;
        boolean sukces = false;

        //act

        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        Assert.assertTrue(sukces);
    }

    /**
     * Pozycja zamowienia o podanym Id nie istnieje w bazie
     * NullPointerException
     */
    @Test
    public void proceedPozycjaZamowienia_PozycjaZamowieniaNieIstnieje_ThrowsException() {
        //arrange

        long idUmieszczenia = 2L;
        long idPozycji = 4L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 10;
        String errorMessage = "";

        //act

        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            errorMessage = e.toString();
        }

        //assert
        Assert.assertEquals("java.lang.NullPointerException", errorMessage);
    }


    /**
     * Umieszczenie o podanym Id nie istnieje w bazie
     * NullPointerException
     */
    @Test
    public void proceedPozycjaZamowienia_UmieszcenieNieIstnieje_ThrowsException() {
        //arrange

        long idUmieszczenia = 4L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 10;
        String errorMessage = "";

        //act

        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            errorMessage = e.toString();
        }

        //assert
        Assert.assertEquals(errorMessage, "java.lang.NullPointerException");
    }


    /**
     * Sprawdza ile razy została wywołana metoda zmniejszająca odpowiednią ilosć towaru w umieszzceniu o podanym Id
     *
     */
    @Test
    public void proceedPozycjaZamowienia_UmieszczenieWywolanaRealizacjaPozycjiZamowienia_AreEqual() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 10;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        verify(umieszczenieRepository, Mockito.times(1)).realizacjaPozycjiZmowienia(idUmieszczenia, IloswWUmieszczeniu1 - 10);

    }


    /**
     * Sprawdza ile razy została wywołana metoda zwiększającą odpowiednią ilosć towaru w pozycji zamówienia o podanym Id
     */
    @Test
    public void proceedPozycjaZamowienia_WywolanaRealizacjaPozycjiZamowienia_AreEqual() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 10;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        verify(pozycjaZamowieniaRepository, Mockito.times(1)).realizacjaPozycjiZmowienia(idPozycji, IloscJuzZrealizowana + 10);

    }

    /**
     * Sprawdza ile razy została wywołana metoda usunięcia umieszczenia
     * Umiesczenie powinno zostac usuniete, gdy po pobraniu z niego okreslonej ilosci towaru, ilosc towaru w umieszczeniu
     * bedzie wynosci 0
     */
    @Test
    public void proceedPozycjaZamowienia_WywolanoUsuniecieUmieszczenia_AreEqual() {
        //arrange
        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 10;

        //act
        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        verify(umieszczenieRepository, Mockito.times(1)).delete(idUmieszczenia);
    }


    /**
     * Sprawdza ile razy została wywołana metoda usunięcia umieszczenia
     * Powinna zostac wywolana 0 razy, gdy w umieszczeniu pozostaje wiecej niż 0 jednostki danego towaru
     */
    @Test
    public void proceedPozycjaZamowienia_NieWywolanoUsuniecieUmieszczenia_AreEqual() {
        //arrange
        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 9;


        //act
        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        verify(umieszczenieRepository, Mockito.times(0)).delete(idUmieszczenia);

    }

    /**
     * Sprawdza ile razy została wywołana metoda zwiększającą odpowiednią ilosć towaru w pozycji zamówienia o podanym Id
     * Powinna zostać wywołana 0 razy, gdy ilosc realizowana jest wieksza niz do zrealizowania
     */
    @Test
    public void proceedPozycjaZamowienia_NieWywolanaRealizacjaPozycjiZamowienia_AreEqual() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 50;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
        }

        //assert
        verify(pozycjaZamowieniaRepository, Mockito.times(0)).realizacjaPozycjiZmowienia(idPozycji, IloscJuzZrealizowana + 50);

    }

    /**
     * Sprawdza ile razy została wywołana metoda zmniejszająca odpowiednią ilosć towaru w umieszzceniu o podanym Id
     * Powinna zostać wywołana 0 razy, gdy ilosc realizowana jest wieksza niz do zrealizowania
     */
    @Test
    public void proceedPozycjaZamowienia_UmieszczenieNieWywolanaRealizacjaPozycjiZamowienia_AreEqual() {
        //arrange
        long idUmieszczenia = 1L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 50;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
        }

        //assert
        verify(umieszczenieRepository, Mockito.times(0)).realizacjaPozycjiZmowienia(idUmieszczenia, IloswWUmieszczeniu1 - 50);
    }

    /**
     * Sprawdza ile razy została wywołana metoda zwiększającą odpowiednią ilosć towaru w pozycji zamówienia o podanym Id
     * Powinna zostać wywołana 0 razy, gdy ilosc realizowana jest wieksza niz w umieszczeniu
     */
    @Test
    public void proceedPozycjaZamowienia_NieWywolanaRealizacjaPozycjiZamowienia2_AreEqual() {
        //arrange
        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 11;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
        }

        //assert
        verify(pozycjaZamowieniaRepository, Mockito.times(0)).realizacjaPozycjiZmowienia(idPozycji, IloscJuzZrealizowana + 11);

    }

    /**
     * Sprawdza ile razy została wywołana metoda zmniejszająca odpowiednią ilosć towaru w umieszzceniu o podanym Id
     * Powinna zostać wywołana 0 razy, gdy ilosc realizowana jest wieksza niz w umieszczeniu
     */
    @Test
    public void proceedPozycjaZamowienia_UmieszczenieNieWywolanaRealizacjaPozycjiZamowienia2_AreEqual() {
        //arrange
        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = 11;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
        }

        //assert
        verify(umieszczenieRepository, Mockito.times(0)).realizacjaPozycjiZmowienia(idUmieszczenia, IloswWUmieszczeniu1 - 11);
    }


    /**
     * Sprawdza ile razy została wywołana metoda zwiększającą odpowiednią ilosć towaru w pozycji zamówienia o podanym Id
     * Powinna zostać wywołana 0 razy, gdy ilosc realizowana jest ujemna
     */
    @Test
    public void proceedPozycjaZamowienia_NieWywolanaRealizacjaPozycjiZamowieniaDlaUjemnej_AreEqual() {
        //arrange
        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = -1;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
        }

        //assert
        verify(pozycjaZamowieniaRepository, Mockito.times(0)).realizacjaPozycjiZmowienia(idPozycji, IloscJuzZrealizowana - 1);

    }

    /**
     * Sprawdza ile razy została wywołana metoda zmniejszająca odpowiednią ilosć towaru w umieszzceniu o podanym Id
     * Powinna zostać wywołana 0 razy, gdy ilosc realizowana jest ujemna
     */
    @Test
    public void proceedPozycjaZamowienia_UmieszczenieNieWywolanaRealizacjaPozycjiZamowieniaDlaUjemnej_AreEqual() {
        //arrange
        long idUmieszczenia = 2L;
        long idPozycji = 1L;
        String sessionId = "53b37a38-7bf1-48dd-9b92-f14e1b691adf";
        int iloscRealizowana = -1;
        boolean sukces = false;

        //act
        try {
            sukces = pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszczenia, iloscRealizowana);
        } catch (Exception e) {
        }

        //assert
        verify(umieszczenieRepository, Mockito.times(0)).realizacjaPozycjiZmowienia(idUmieszczenia, IloswWUmieszczeniu1 + 1);
    }
}
package com.StoreX.api.impl;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.common.datatypes.enumerations.TypOdbioru;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.persistence.entity.BilansEntities.Bilans;
import com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaPrzyjecia;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaWydania;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PrzyjecieZamowienia;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.WydanieZamowienia;
import com.StoreX.persistence.entity.TowarEntities.Jednostka;
import com.StoreX.persistence.entity.TowarEntities.Kategoria;
import com.StoreX.persistence.entity.TowarEntities.Towar;
import com.StoreX.persistence.entity.UmieszczenieEntities.Lokalizacja;
import com.StoreX.persistence.entity.UmieszczenieEntities.Umieszczenie;
import com.StoreX.persistence.entity.ZamowienieEntities.Klient;
import com.StoreX.persistence.entity.ZamowienieEntities.PozycjaZamowienia;
import com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieDostawy;
import com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieZakupu;
import com.StoreX.service.HelperServices.*;
import com.StoreX.service.ZamowienieServices.PozycjaZamowieniaSearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class TestGeneratorImpl {

    @Autowired
    TowarService towarService;
    @Autowired
    PozycjaBilansuService pozycjaBilansuService;
    @Autowired
    ZamowienieZakupuService zamowienieZakupuService;
    @Autowired
    PozycjaZamowieniaService pozycjaZamowieniaService;
    @Autowired
    KategoriaService kategoriaService;
    @Autowired
    JednostkaService jednostkaService;
    @Autowired
    UmieszczenieService umieszczenieService;
    @Autowired
    LokalizacjaService lokalizacjaService;
    @Autowired
    KlientService klientService;
    @Autowired
    ZamowienieDostawyService zamowienieDostawyService;
    @Autowired
    WydanieZamowieniaService wydanieZamowieniaService;
    @Autowired
    PrzyjecieZamowieniaService przyjecieZamowieniaService;
    @Autowired
    PozycjaPrzyjeciaService pozycjaPrzyjeciaService;
    @Autowired
    PozycjaWydaniaService pozycjaWydaniaService;
    @Autowired
    BilansService bilansService;
    @Autowired
    PozycjaZamowieniaSearchService pozycjaZamowieniaSearchService;

    private ModelMapper modelMapper = new ModelMapper();


    @RequestMapping(value = "/addTest/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PozycjaZamowieniaTO>> addTest(String sessionId) {

        Klient klient1 = new Klient();
        klient1.setImie("Jan");
        klient1.setKodPocztowy("62-100");
        klient1.setNazwisko("BR");
        klient1.setLogin("user");
        klient1.setMiasto("Leszno");
        klient1.setNumerDomu("4");
        klient1.setUlica("Nowa");
        klient1.setEmail("jan.br@gmail.com");
        klientService.add(klient1);
        Klient klient2 = new Klient();
        klient2.setImie("Adam");
        klient2.setKodPocztowy("62-100");
        klient2.setNazwisko("Kowalski");
        klient2.setLogin("user");
        klient2.setMiasto("Leszno");
        klient2.setNumerDomu("5");
        klient2.setUlica("Stara");
        klient2.setEmail("adam.br@gmail.com");
        klientService.add(klient2);
        Klient klient3 = new Klient();
        klient3.setImie("Kamil");
        klient3.setKodPocztowy("63-100");
        klient3.setNazwisko("MK");
        klient3.setLogin("user");
        klient3.setMiasto("Opole");
        klient3.setNumerDomu("4");
        klient3.setUlica("Polma");
        klient3.setEmail("mk@gmail.com");
        klientService.add(klient3);

        Kategoria kategoria1 = new Kategoria();
        kategoria1.setKategoria("Samochodowe");
        kategoriaService.add(kategoria1);
        Kategoria kategoria2 = new Kategoria();
        kategoria2.setKategoria("Rowerowe");
        kategoriaService.add(kategoria2);
        Kategoria kategoria3 = new Kategoria();
        kategoria3.setKategoria("Narzędzia");
        kategoriaService.add(kategoria3);

        Jednostka jednostka1 = new Jednostka();
        jednostka1.setRodzaj("Opakowanie");
        jednostkaService.add(jednostka1);

        Jednostka jednostka2 = new Jednostka();
        jednostka2.setRodzaj("sztuki");
        jednostkaService.add(jednostka2);


        Towar t1 = new Towar("t1A48", "Rama", 0, 2,jednostka2,kategoria2,150);
        Towar t2 = new Towar("t2B28", "Kolo", 0, 2,jednostka2,kategoria2,150);
        Towar t3 = new Towar("t3A38", "Dzwonek", 0, 2,jednostka2,kategoria2,200);
        Towar t4 = new Towar("t4A47", "Korba", 0, 2,jednostka2,kategoria2,150);
        Towar t5 = new Towar("t5U48", "Lancuch", 0, 2,jednostka2,kategoria2,1140);
        Towar t6 = new Towar("t6J48", "Pompka", 0, 2,jednostka2,kategoria2,1500);
        Towar t7 = new Towar("t7A49", "Siodelko", 0, 2,jednostka2,kategoria2,200);
        Towar t8 = new Towar("t8A50", "Fotel", 0, 2,jednostka2,kategoria1,150);
        Towar t9 = new Towar("t9A48", "Kierownica", 0, 2,jednostka2,kategoria1,150);
        Towar t10 = new Towar("t10A48", "Opona", 0, 2,jednostka2,kategoria1,150);
        Towar t11 = new Towar("t11A78", "Wiertarka", 0, 2,jednostka2,kategoria3,150);
        Towar t12 = new Towar("t12D48", "Srubki", 0, 2,jednostka1,kategoria3,150);
        Towar t13 = new Towar("t13E48", "Mlotek", 0, 2,jednostka2,kategoria3,150);

        List<Towar> towarList = new ArrayList<Towar>();
        towarList.add(t1);
        towarList.add(t2);
        towarList.add(t3);
        towarList.add(t4);
        towarList.add(t5);
        towarList.add(t6);
        towarList.add(t7);
        towarList.add(t8);
        towarList.add(t9);
        towarList.add(t10);
        towarList.add(t11);
        towarList.add(t12);
        towarList.add(t13);
        towarService.saveTowar(t1);
        towarService.saveTowar(t2);
        towarService.saveTowar(t3);
        towarService.saveTowar(t4);
        towarService.saveTowar(t5);
        towarService.saveTowar(t6);
        towarService.saveTowar(t7);
        towarService.saveTowar(t8);
        towarService.saveTowar(t9);
        towarService.saveTowar(t10);
        towarService.saveTowar(t11);
        towarService.saveTowar(t12);
        towarService.saveTowar(t13);

        Calendar c1 = Calendar.getInstance();
        c1.set(2017,11,1);
        Calendar c2 = Calendar.getInstance();
        c2.set(2018,0,15);

        ZamowienieZakupu z1 = new ZamowienieZakupu("Z1", c1.getTime(), StatusWydania.Zaakceptowane, klient1, TypOdbioru.Wysylka, c2.getTime());
        ZamowienieZakupu z2 = new ZamowienieZakupu("Z2", c1.getTime(), StatusWydania.Gotowe, klient1, TypOdbioru.Osobiscie, c2.getTime());
        ZamowienieZakupu z3 = new ZamowienieZakupu("Z3", c1.getTime(), StatusWydania.Oczekujace, klient1, TypOdbioru.Osobiscie, c2.getTime());
        ZamowienieZakupu z4 = new ZamowienieZakupu("Z4", c1.getTime(), StatusWydania.Zaakceptowane, klient1, TypOdbioru.Wysylka, c2.getTime());
        ZamowienieZakupu z5 = new ZamowienieZakupu("Z5", c1.getTime(), StatusWydania.Zaakceptowane, klient1, TypOdbioru.Osobiscie, c2.getTime());
        ZamowienieZakupu z6 = new ZamowienieZakupu("Z6", c1.getTime(), StatusWydania.Zaakceptowane, klient1, TypOdbioru.Osobiscie, c2.getTime());
        zamowienieZakupuService.addZamowienie(sessionId, z1);
        zamowienieZakupuService.addZamowienie(sessionId, z2);
        zamowienieZakupuService.addZamowienie(sessionId, z3);
        zamowienieZakupuService.addZamowienie(sessionId, z4);
        zamowienieZakupuService.addZamowienie(sessionId, z5);
        zamowienieZakupuService.addZamowienie(sessionId, z6);


        List<PozycjaZamowienia> pzList = new ArrayList<PozycjaZamowienia>();
        pzList.add(new PozycjaZamowienia(20,0, t1, z1));
        pzList.add( new PozycjaZamowienia(20,0, t2, z1));
        pzList.add(new PozycjaZamowienia(10,0, t3, z1));
        pzList.add( new PozycjaZamowienia(10,0, t4, z1));
        pzList.add( new PozycjaZamowienia(20,0, t5, z1));
        pzList.add( new PozycjaZamowienia(10,0, t6, z1));
        pzList.add( new PozycjaZamowienia(20,0, t7, z1));
        pzList.add( new PozycjaZamowienia(10,0, t8, z1));
        pzList.add( new PozycjaZamowienia(10,0, t9, z1));
        pzList.add( new PozycjaZamowienia(40,0, t10, z1));

        pzList.add(new PozycjaZamowienia(20,0, t1, z2));
        pzList.add(new PozycjaZamowienia(10,0, t2, z2));
        pzList.add(new PozycjaZamowienia(20,0, t13, z2));
        pzList.add( new PozycjaZamowienia(20,0, t11, z2));
        pzList.add(new PozycjaZamowienia(30,0, t6, z2));
        pzList.add( new PozycjaZamowienia(20,0, t7, z2));

        pzList.add( new PozycjaZamowienia(10,0, t1, z3));
        pzList.add(new PozycjaZamowienia(10,0, t2, z3));
        pzList.add( new PozycjaZamowienia(20,0, t5, z3));
        pzList.add(new PozycjaZamowienia(20,0, t4, z3));
        pzList.add( new PozycjaZamowienia(40,0, t13, z3));
        pzList.add(new PozycjaZamowienia(20,0, t12, z3));

        pzList.add( new PozycjaZamowienia(10,0, t1, z4));
        pzList.add(new PozycjaZamowienia(20,0, t11, z4));
        pzList.add( new PozycjaZamowienia(10,0, t12, z4));
        pzList.add( new PozycjaZamowienia(20,0, t13, z4));
        pzList.add(new PozycjaZamowienia(10,0, t2, z4));
        pzList.add(new PozycjaZamowienia(20,0, t3, z4));
        pzList.add(new PozycjaZamowienia(10,0, t4, z4));

        pzList.add( new PozycjaZamowienia(20,0, t10, z5));
        pzList.add(new PozycjaZamowienia(30,0, t9, z5));
        pzList.add( new PozycjaZamowienia(20,0, t7, z5));
        pzList.add( new PozycjaZamowienia(10,0, t6, z5));
        pzList.add( new PozycjaZamowienia(20,0, t1, z5));

        pzList.add( new PozycjaZamowienia(20,0, t3, z6));
        pzList.add( new PozycjaZamowienia(10,0, t2, z6));
        pzList.add( new PozycjaZamowienia(20,0, t1, z6));

        for (PozycjaZamowienia pozycja: pzList) {
            pozycjaZamowieniaService.add(pozycja);
        }

        List<Lokalizacja> lokalizacjaList = new ArrayList<Lokalizacja>();
        String kodL = "L1";
        int regal = 0;
        int rzad = 0;
        for(int i = 0; i < 39; i++) {
            regal = regal%8 == 0 ? regal : regal + 1;
            rzad = rzad%5 == 0 ? rzad : rzad + 1;
            lokalizacjaList.add(new Lokalizacja(kodL + i,regal,rzad,i%7));
        }

        for (Lokalizacja pozycja: lokalizacjaList) {
            lokalizacjaService.add(pozycja);
        }

        Random rand = new Random();
        List<Umieszczenie> umieszczenieList = new ArrayList<Umieszczenie>();
        for (int i = 0; i < 39; i ++ ) {
            umieszczenieList.add(new Umieszczenie((double)rand.nextInt(30) + 20, towarList.get(i%13),lokalizacjaList.get(i)));
        }

        for (Umieszczenie pozycja: umieszczenieList) {
            umieszczenieService.addService(pozycja);
        }


        Calendar c3 = Calendar.getInstance();
        c3.set(2017,10,10);

        List<WydanieZamowienia> wydanieZamowieniaList = new ArrayList<WydanieZamowienia>();

        for (int i = 0; i < 10; i ++){
            if(i%2 ==0 )
                wydanieZamowieniaList.add(new WydanieZamowienia(c3.getTime(), z1));
            else
                wydanieZamowieniaList.add(new WydanieZamowienia(c3.getTime(), z2));
        }

        for (WydanieZamowienia pozycja: wydanieZamowieniaList) {
            wydanieZamowieniaService.add(pozycja);
        }

        List<PozycjaWydania> pozycjaWydaniaList = new ArrayList<PozycjaWydania>();
        int licznik = 0;
        for (WydanieZamowienia pozycja: wydanieZamowieniaList) {
            int ile = rand.nextInt(2) + 6;
            for(int i = 0; i < ile; i ++){
                pozycjaWydaniaList.add(new PozycjaWydania((double)rand.nextInt(20) + 1, towarList.get(licznik % 13),pozycja));
                licznik++;
            }

        }

        for (PozycjaWydania pozycja: pozycjaWydaniaList) {
            pozycjaWydaniaService.add(pozycja);
        }



        ZamowienieDostawy zamowienieDostawy = new ZamowienieDostawy();
        zamowienieDostawyService.add(zamowienieDostawy);
        List<PrzyjecieZamowienia> przyjecieZamowieniaList = new ArrayList<PrzyjecieZamowienia>();

        for (int i = 0; i < 10; i ++){
            if(i%2 ==0 )
                przyjecieZamowieniaList.add(new PrzyjecieZamowienia(c3.getTime(), zamowienieDostawy));
            else
                przyjecieZamowieniaList.add(new PrzyjecieZamowienia(c3.getTime(), zamowienieDostawy));
        }

        for (PrzyjecieZamowienia pozycja: przyjecieZamowieniaList) {
            przyjecieZamowieniaService.add(pozycja);
        }

        List<PozycjaPrzyjecia> pozycjaPrzyjeciaList = new ArrayList<PozycjaPrzyjecia>();
        licznik = 0;
        for (PrzyjecieZamowienia pozycja: przyjecieZamowieniaList) {
            int ile = rand.nextInt(2) + 6;
            for(int i = 0; i < ile; i ++){
                pozycjaPrzyjeciaList.add(new PozycjaPrzyjecia((double)rand.nextInt(20) + 20, towarList.get(licznik % 13),pozycja));
                licznik++;
            }

        }

        for (PozycjaPrzyjecia pozycja: pozycjaPrzyjeciaList) {
            pozycjaPrzyjeciaService.add(pozycja);
        }


        Calendar c4 = Calendar.getInstance();
        c4.set(2017,9,10);

        Calendar c5 = Calendar.getInstance();
        c5.set(2017,11,10);

        Bilans b1 = new Bilans(c5.getTime(),c4.getTime());
        bilansService.saveBilans(b1);
        PozycjaBilansu pb = new PozycjaBilansu(10, t1, b1);
        pozycjaBilansuService.add(pb);



        List<PozycjaZamowieniaBO> pozycjeZamowieniaBO = null;
        try {
            pozycjeZamowieniaBO = pozycjaZamowieniaSearchService.findAllforZamowienie(sessionId,new Long(41));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        List<PozycjaZamowieniaTO> results = new ArrayList<>();

        for (PozycjaZamowieniaBO pozycja : pozycjeZamowieniaBO) {
            results.add(modelMapper.map(pozycja, PozycjaZamowieniaTO.class));
        }

        return new ResponseEntity<List<PozycjaZamowieniaTO>>(results, HttpStatus.OK);

    }
}

package com.StoreX.api.impl;

import com.StoreX.api.BilansApi;
import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.common.datatypes.enumerations.TypOdbioru;
import com.StoreX.common.datatypes.to.BilansTO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.persistence.entity.*;
import com.StoreX.service.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class BilansApiImpl implements BilansApi{

    @Autowired
    private BilansService bilansService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @RequestMapping(value = "/getLastBilans/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BilansTO> getLastBilans(@RequestHeader(value = "SessionID") String sessionId){
        BilansBO bilansBO = null;
        try {
            bilansBO = bilansService.findLast(sessionId);
        } catch (Exception e) {
            return new ResponseEntity<BilansTO>(HttpStatus.UNAUTHORIZED);
        }
        if (bilansBO!=null) {
            BilansTO result = modelMapper.map(bilansBO, BilansTO.class);
            return new ResponseEntity<BilansTO>(result, HttpStatus.OK);
        }
        else {
            BilansTO result = null;
            return new ResponseEntity<BilansTO>(result, HttpStatus.OK);
        }
    }

    @Override
    @RequestMapping(value = "/addBilans/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addBilans(@RequestBody Date dataBilansowana, @RequestHeader(value = "SessionID") String sessionId){
        boolean dodano = false;
        try {
            dodano = bilansService.addBilans(sessionId,dataBilansowana);
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(dodano, HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity<Boolean>(dodano, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<Boolean>(dodano, HttpStatus.OK);
    }

    /*
    Created for test purposes, to be removed
     */

    @Autowired
    TowarService towarService;
    @Autowired
    PozycjaBilansuService pozycjaBilansuService;
    @Autowired
    ZamowienieZakupuService zamowienieZakupuService;
    @Autowired
    PozycjaZamowieniaService pozycjaZamowieniaService;
    @Override
    @RequestMapping(value = "/addBilansTest/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> addBilansTest(Date dataBilansowana, String sessionId) {
        Bilans b = new Bilans();
        Bilans b2 = new Bilans();
        Bilans b3 = new Bilans();
        b.setDataBilansu(new Date(1996,12,12));
        b2.setDataBilansu(new Date(1991,12,12));
        b3.setDataBilansu(new Date(1995,12,12));
//        bilansService.saveBilans(b);
//       bilansService.saveBilans(b2);
//       bilansService.saveBilans(b3);
//        Bilans b4 = bilansService.findLast();

        ZamowienieZakupu z = new ZamowienieZakupu();
        z.setStatus(StatusWydania.Zaakceptowane);
        ZamowienieZakupu z1 = new ZamowienieZakupu();
        z1.setStatus(StatusWydania.Zaakceptowane);
        ZamowienieZakupu z2 = new ZamowienieZakupu();
        z2.setStatus(StatusWydania.Oczekujące);
        z2.setKlient(new Klient());


        ZamowienieZakupuBO z3 = modelMapper.map(z2, ZamowienieZakupuBO.class);
        z3.setStatus(StatusWydania.Gotowe);
        z3.setID(new Long(4));
//        zamowienieZakupuService.addZamowienie(sessionId,z);
//        zamowienieZakupuService.addZamowienie(sessionId,z1);
//        zamowienieZakupuService.addZamowienie(sessionId,z2);
            zamowienieZakupuService.addZamowienie(sessionId,z2);


        return new ResponseEntity<Long>(z3.getID(),HttpStatus.OK);

    }

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

    @Override
    @RequestMapping(value = "/addTest/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PozycjaZamowieniaTO>> addTest(String sessionId) {
//        Klient kl = new Klient();
//        kl.setImie("Jan");
//        kl.setKodPocztowy("62-100");
//        kl.setNazwisko("BR");
//        kl.setLogin("user");
//        kl.setMiasto("Leszno");
//        kl.setNumerDomu("4");
//        kl.setUlica("Nowa");
//        klientService.add(kl);
//        ZamowienieZakupu z = new ZamowienieZakupu();
//        Towar t = new Towar();
//        Kategoria k = new Kategoria(new Long(2), "Picie");
//        Jednostka j = new Jednostka(new Long(1),"Litry");
//        kategoriaService.add(k);
//        jednostkaService.add(j);
//        t.setNazwa("NazwaTowaru1");
//        t.setIloscMinimalna(10);
//        t.setKategoria(k);
//        t.setKod("kodTowaru");
//        t.setIlostan(100);
//        t.setJednostka(j);
//        t.setPotrzebujeZamowienia(false);
//
//        z.setStatus(StatusWydania.Zaakceptowane);
//
//        z.setTerminRealizacji(new Date(118,11,11));
//        z.setDataZlozenia(new Date(116,11,11));
//        PozycjaZamowienia pz = new PozycjaZamowienia();
//
//        Towar t2 = new Towar();
//        t2.setNazwa("NazwaTowaru2");
//        t2.setIloscMinimalna(10);
//        t2.setKategoria(k);
//        t2.setKod("drugiTwoar");
//        t2.setIlostan(20);
//        t2.setJednostka(j);
//        t2.setPotrzebujeZamowienia(false);
//        z.setKlient(kl);
//        z.setTypOdbioru(TypOdbioru.Wysylka);
//        zamowienieZakupuService.addZamowienie(sessionId, z);
//
//        towarService.saveTowar(t);
//        towarService.saveTowar(t2);
//
//        Lokalizacja l1 = new Lokalizacja();
//        l1.setKod("kod1");
//        l1.setNumerRegalu(1);
//        l1.setNumerRzedu(1);
//        l1.setNumerSektora(1);
//        lokalizacjaService.add(l1);
//        Lokalizacja l2 = new Lokalizacja();
//        l2.setKod("kod2");
//        l2.setNumerRegalu(2);
//        l2.setNumerRzedu(2);
//        l2.setNumerSektora(2);
//        lokalizacjaService.add(l2);
//        Lokalizacja l3 = new Lokalizacja();
//        l3.setKod("kod3");
//        l3.setNumerRegalu(3);
//        l3.setNumerRzedu(3);
//        l3.setNumerSektora(3);
//        lokalizacjaService.add(l3);
//
//        Umieszczenie umieszczenie = new Umieszczenie();
//        umieszczenie.setTowar(t);
//        umieszczenie.setLokalizacja(l1);
//        Umieszczenie umieszczenie2 = new Umieszczenie();
//        umieszczenie2.setLokalizacja(l2);
//        umieszczenie2.setTowar(t2);
//        Umieszczenie umieszczenie3 = new Umieszczenie();
//        umieszczenie3.setLokalizacja(l3);
//        umieszczenie3.setTowar(t);
//        umieszczenieService.addService(umieszczenie);
//        umieszczenieService.addService(umieszczenie2);
//        umieszczenieService.addService(umieszczenie3);
//        pz.setTowar(t);
//        pz.setZamowienie(z);
//        pz.setIlosc(10);
//        pz.setZrealizowano(0);
//        pozycjaZamowieniaService.add(pz);
//
//        PozycjaZamowienia pz2 = new PozycjaZamowienia();
//        pz2.setZamowienie(z);
//        pz2.setTowar(t2);
//        pz2.setIlosc(20);
//        pz2.setZrealizowano(0);
//        pozycjaZamowieniaService.add(pz2);
//
//        Bilans b = new Bilans();
//        b.setDataBilansu(new Date(117,11,11));
//        PozycjaBilansu pb1 = new PozycjaBilansu();
//        pb1.setBilans(b);
//        pb1.setIlosc(10.0);
//        PozycjaBilansu pb2 = new PozycjaBilansu();
//        pb2.setBilans(b);
//        pb2.setIlosc(20.0);
//        bilansService.saveBilans(b);
//        pozycjaBilansuService.savePozycjaBilansu(pb1);
//        pozycjaBilansuService.savePozycjaBilansu(pb2);

        /*
        Do testowania dodawania bilansów
         */

        Towar t1 = new Towar();
        Kategoria k = new Kategoria();
        k.setKategoria("K1");
        Jednostka j = new Jednostka();
        j.setRodzaj("J1");
        kategoriaService.add(k);
        jednostkaService.add(j);
        t1.setNazwa("NazwaTestowaTowaru");
        t1.setIloscMinimalna(10);
        t1.setKategoria(k);
        t1.setKod("2449124");
        t1.setIlostan(100);
        t1.setJednostka(j);
        t1.setPotrzebujeZamowienia(false);
        Towar t2 = new Towar();
        t2.setNazwa("NazwaDrugiegoTest");
        t2.setIloscMinimalna(10);
        t2.setKategoria(k);
        t2.setKod("781242");
        t2.setIlostan(100);
        t2.setJednostka(j);
        t2.setPotrzebujeZamowienia(false);

        towarService.saveTowar(t1);
        towarService.saveTowar(t2);


        ZamowienieZakupu zz = new ZamowienieZakupu();
        ZamowienieDostawy zd = new ZamowienieDostawy();
        zamowienieZakupuService.addZamowienie(sessionId,zz);
        zamowienieDostawyService.add(zd);

        Bilans staryBilans = new Bilans();
        staryBilans.setDataBilansu(new Date(117,10,11));
        bilansService.saveBilans(staryBilans);

        WydanieZamowienia wz1 = new WydanieZamowienia();
        WydanieZamowienia wz2 = new WydanieZamowienia();
        PrzyjecieZamowienia pz1 = new PrzyjecieZamowienia();
        PrzyjecieZamowienia pz2 = new PrzyjecieZamowienia();
        wz1.setData(new Date(117,11,11));
        wz2.setData(new Date(117,11,11));
        wz1.setZamowienie(zz);
        wz2.setZamowienie(zz);
        pz1.setData(new Date(117,11,11));
        pz2.setData(new Date(117,11,11));
        pz1.setZamowienie(zd);
        pz2.setZamowienie(zd);
        wydanieZamowieniaService.add(wz1);
        wydanieZamowieniaService.add(wz2);
        przyjecieZamowieniaService.add(pz1);
        przyjecieZamowieniaService.add(pz2);

        PozycjaWydania pw1 = new PozycjaWydania();
        pw1.setTowar(t1);
        pw1.setIlosc(10);
        pw1.setWydanieZamowienia(wz1);
        PozycjaWydania pw2 = new PozycjaWydania();
        pw2.setTowar(t2);
        pw2.setIlosc(10);
        pw2.setWydanieZamowienia(wz1);
        PozycjaWydania pw3 = new PozycjaWydania();
        pw3.setTowar(t1);
        pw3.setIlosc(15);
        pw3.setWydanieZamowienia(wz2);
        PozycjaWydania pw4 = new PozycjaWydania();
        pw4.setTowar(t2);
        pw4.setIlosc(20);
        pw4.setWydanieZamowienia(wz2);

        PozycjaPrzyjecia pp1 = new PozycjaPrzyjecia();
        pp1.setTowar(t1);
        pp1.setIlosc(100);
        pp1.setPrzyjecieZamowienia(pz1);
        PozycjaPrzyjecia pp2 = new PozycjaPrzyjecia();
        pp2.setTowar(t2);
        pp2.setIlosc(90);
        pp2.setPrzyjecieZamowienia(pz1);
        PozycjaPrzyjecia pp3 = new PozycjaPrzyjecia();
        pp3.setTowar(t1);
        pp3.setIlosc(40);
        pp3.setPrzyjecieZamowienia(pz2);

        pozycjaPrzyjeciaService.add(pp1);
        pozycjaPrzyjeciaService.add(pp2);
        pozycjaPrzyjeciaService.add(pp3);

        pozycjaWydaniaService.add(pw1);
        pozycjaWydaniaService.add(pw2);
        pozycjaWydaniaService.add(pw3);
        pozycjaWydaniaService.add(pw4);





        List<PozycjaZamowieniaBO> pozycjeZamowieniaBO = null;
        try {
            pozycjeZamowieniaBO = pozycjaZamowieniaService.findAllforZamowienie(sessionId,new Long(41));
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

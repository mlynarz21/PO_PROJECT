package com.StoreX.api.impl;

import com.StoreX.api.BilansApi;
import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.common.datatypes.to.BilansTO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.persistence.entity.*;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.persistence.repository.TowarRepository;
import com.StoreX.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.util.calendar.BaseCalendar;

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
        BilansBO bilansBO;
        try {
            bilansBO  = bilansService.addBilans(sessionId,dataBilansowana);
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<Boolean>(HttpStatus.OK);
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

    @Override
    @RequestMapping(value = "/addTest/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PozycjaZamowieniaTO>> addTest(String sessionId) {
        Klient kl = new Klient();
        kl.setImie("Jan");
        kl.setKodPocztowy("62-100");
        kl.setNazwisko("BR");
        kl.setLogin("user");
        kl.setMiasto("Leszno");
        kl.setNumerDomu("4");
        kl.setUlica("Nowa");
        klientService.add(kl);
        ZamowienieZakupu z = new ZamowienieZakupu();
        Towar t = new Towar();
        Kategoria k = new Kategoria(new Long(2), "Picie");
        Jednostka j = new Jednostka(new Long(1),"Litry");
        kategoriaService.add(k);
        jednostkaService.add(j);
        t.setNazwa("NazwaTowaru1");
        t.setIloscMinimalna(10);
        t.setKategoria(k);
        t.setKod("kodTowaru");
        t.setIlostan(100);
        t.setJednostka(j);
        t.setPotrzebujeZamowienia(false);

        z.setStatus(StatusWydania.Zaakceptowane);

        z.setTerminRealizacji(new Date(118,11,11));
        z.setDataZlozenia(new Date(116,11,11));
        PozycjaZamowienia pz = new PozycjaZamowienia();

        Towar t2 = new Towar();
        t2.setNazwa("NazwaTowaru2");
        t2.setIloscMinimalna(10);
        t2.setKategoria(k);
        t2.setKod("drugiTwoar");
        t2.setIlostan(20);
        t2.setJednostka(j);
        t2.setPotrzebujeZamowienia(false);
        z.setKlient(kl);
        zamowienieZakupuService.addZamowienie(sessionId, z);

        towarService.saveTowar(t);
        towarService.saveTowar(t2);

        Lokalizacja l1 = new Lokalizacja();
        l1.setKod("kod1");
        l1.setNumerRegalu(1);
        l1.setNumerRzedu(1);
        l1.setNumerSektora(1);
        lokalizacjaService.add(l1);
        Lokalizacja l2 = new Lokalizacja();
        l2.setKod("kod2");
        l2.setNumerRegalu(2);
        l2.setNumerRzedu(2);
        l2.setNumerSektora(2);
        lokalizacjaService.add(l2);
        Lokalizacja l3 = new Lokalizacja();
        l3.setKod("kod3");
        l3.setNumerRegalu(3);
        l3.setNumerRzedu(3);
        l3.setNumerSektora(3);
        lokalizacjaService.add(l3);

        Umieszczenie umieszczenie = new Umieszczenie();
        umieszczenie.setTowar(t);
        umieszczenie.setLokalizacja(l1);
        Umieszczenie umieszczenie2 = new Umieszczenie();
        umieszczenie2.setLokalizacja(l2);
        umieszczenie2.setTowar(t2);
        Umieszczenie umieszczenie3 = new Umieszczenie();
        umieszczenie3.setLokalizacja(l3);
        umieszczenie3.setTowar(t);
        umieszczenieService.addService(umieszczenie);
        umieszczenieService.addService(umieszczenie2);
        umieszczenieService.addService(umieszczenie3);
        pz.setTowar(t);
        pz.setZamowienie(z);
        pz.setIlosc(10);
        pz.setZrealizowano(0);
        pozycjaZamowieniaService.add(pz);

        PozycjaZamowienia pz2 = new PozycjaZamowienia();
        pz2.setZamowienie(z);
        pz2.setTowar(t2);
        pz2.setIlosc(20);
        pz2.setZrealizowano(0);
        pozycjaZamowieniaService.add(pz2);



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

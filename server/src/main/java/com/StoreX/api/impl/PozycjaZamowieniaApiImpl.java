package com.StoreX.api.impl;

import com.StoreX.api.PozycjaZamowieniaApi;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.ZamowienieBO;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.common.datatypes.to.ZamowienieTO;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import com.StoreX.persistence.entity.Zamowienie;
import com.StoreX.service.PozycjaZamowieniaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;


//todo: change to pozycja zamowienia ZAKUPU?
@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class PozycjaZamowieniaApiImpl implements PozycjaZamowieniaApi{

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    PozycjaZamowieniaService pozycjaZamowieniaService;

    @Override
    @RequestMapping(value = "/getPozycjeZamowienia/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PozycjaZamowieniaTO>> getPozycjeZamowienia(@RequestBody Long ID, @RequestHeader(value = "SessionID") String sessionId){
        List<PozycjaZamowieniaBO> pozycjeZamowieniaBO = null;
        try {
            pozycjeZamowieniaBO = pozycjaZamowieniaService.findAllforZamowienie(sessionId, ID);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        List<PozycjaZamowieniaTO> results = new ArrayList<>();

        for (PozycjaZamowieniaBO pozycja : pozycjeZamowieniaBO) {
            results.add(modelMapper.map(pozycja, PozycjaZamowieniaTO.class));
        }

        return new ResponseEntity<List<PozycjaZamowieniaTO>>(results, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/updatePozycjaZamowienia/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> proceedPozycjaZamowienia(@RequestBody Long idPozyjcji,  Long idUmieszczenia,  double ilosc, @RequestHeader(value = "SessionID") String sessionId) {
        boolean wykonano = false;

        try {
           pozycjaZamowieniaService.ProceedPozycjaZamowienia(sessionId, idPozyjcji, idUmieszczenia, ilosc);
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity<Boolean>(wykonano, HttpStatus.NOT_ACCEPTABLE);
        }


        wykonano = true;
        return new ResponseEntity<Boolean>(wykonano, HttpStatus.OK);
    }

//    @Override
//    @RequestMapping(value = "/updatePozycjaZamowienia/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Boolean> proceedPozycjaZamowienia( @RequestHeader(value = "SessionID") String sessionId) {
//        boolean wykonano = false;
//        try {
//            pozycjaZamowieniaService.ProceedPozycjaZamowienia(sessionId,new Long(48) ,new Long(16), 100);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<Boolean>(wykonano, HttpStatus.UNAUTHORIZED);
//        }catch (Exception e){
//            return new ResponseEntity<Boolean>(wykonano, HttpStatus.NOT_ACCEPTABLE);
//        }
//
//
//        wykonano = true;
//        return new ResponseEntity<Boolean>(wykonano, HttpStatus.OK);
//    }

}

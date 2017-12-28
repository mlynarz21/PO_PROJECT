package com.StoreX.api.impl;

import com.StoreX.api.PozycjaZamowieniaApi;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
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
            pozycjeZamowieniaBO = pozycjaZamowieniaService.findAllforZamowienie(ID);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        List<PozycjaZamowieniaTO> results = new ArrayList<>();

        for (PozycjaZamowieniaBO pozycja : pozycjeZamowieniaBO) {
            results.add(modelMapper.map(pozycja, PozycjaZamowieniaTO.class));
        }

        return new ResponseEntity<List<PozycjaZamowieniaTO>>(results, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/proceedPozycjaZamowienia/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> proceedPozycjaZamowienia(@RequestBody List<Double> transferList, @RequestHeader(value = "SessionID") String sessionId) {
        Long idPozyjcji = transferList.get(0).longValue();
        Long idUmieszczenia = transferList.get(1).longValue();
        double ilosc = transferList.get(2);

        try {
           pozycjaZamowieniaService.ProceedPozycjaZamowienia(sessionId, idPozyjcji, idUmieszczenia, ilosc);
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
        }
        boolean updated = true;
        return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
    }

//    @Override
//    @RequestMapping(value = "/updatePozycjaZamowienia/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Boolean> proceedPozycjaZamowienia( @RequestHeader(value = "SessionID") String sessionId) {
//
//        try {
//            pozycjaZamowieniaService.ProceedPozycjaZamowienia(sessionId,new Long(48) ,new Long(14), 95);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
//        }
//        boolean updated = true;
//        return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
//    }

}

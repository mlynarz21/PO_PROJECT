package com.StoreX.api.impl;

import com.StoreX.api.PozycjaZamowieniaApi;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.common.datatypes.to.ZamowienieTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class PozycjaZamowieniaApiImpl implements PozycjaZamowieniaApi{

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @RequestMapping(value = "/getPozycjeZamowienia/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PozycjaZamowieniaTO>> getPozycjeZamowienia(@RequestBody ZamowienieTO zamowienie, @RequestHeader(value = "SessionID") String sessionId){
        List<PozycjaZamowieniaBO> pozycjeZamowieniaBO = null;
//        try {
//            pozycjaZamowieniaBO = searchService.findAllArtifacts(sessionId);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<List<PozycjaZamowieniaTO>>(HttpStatus.UNAUTHORIZED);
//        }

        List<PozycjaZamowieniaTO> results = new ArrayList<>();

        for (PozycjaZamowieniaBO pozycja : pozycjeZamowieniaBO) {
            results.add(modelMapper.map(pozycja, PozycjaZamowieniaTO.class));
        }

        return new ResponseEntity<List<PozycjaZamowieniaTO>>(results, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/updatePozycjaZamowienia/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updatePozycjaZamowienia(@RequestBody PozycjaZamowieniaTO pozycjaZamowienia, @RequestHeader(value = "SessionID") String sessionId) {
        boolean updated = false;
//        try {
//            updated = bookingService.bookArtifactById(sessionId, modelMapper.map(incomingArtifactTo, ArtifactBo.class));
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
//        }

        if (updated) {
            return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(updated, HttpStatus.FOUND);
        }
    }

}

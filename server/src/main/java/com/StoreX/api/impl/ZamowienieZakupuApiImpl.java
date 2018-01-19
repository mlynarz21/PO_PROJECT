package com.StoreX.api.impl;

import com.StoreX.api.ZamowienieZakupuApi;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import com.StoreX.service.ZamowienieServices.ZamowienieZakupuSearchService;
import com.StoreX.service.ZamowienieServices.ZamowienieZakupuUpdateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class ZamowienieZakupuApiImpl implements ZamowienieZakupuApi{

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ZamowienieZakupuSearchService zamowienieZakupuSearchService;
    @Autowired
    ZamowienieZakupuUpdateService zamowienieZakupuUpdateService;

    /**
     * Pobiera wszystkie zamowienia zakupu o statusie Zaakceptowane
     * @param sessionId Id sesji
     * @return Lista zamowien zakupu o statusie Zaakceptowane
     */
    @Override
    @RequestMapping(value = "/getAllZaakceptowane/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZamowienieZakupuTO>> getAllZaakceptowane(@RequestHeader(value = "SessionID") String sessionId){
        List<ZamowienieZakupuBO> zamowieniaBO = null;
        try {
            zamowieniaBO = zamowienieZakupuSearchService.findAllAccepted(sessionId);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<ZamowienieZakupuTO> results = new ArrayList<>();

        for (ZamowienieZakupuBO zamwienie : zamowieniaBO) {
            results.add(modelMapper.map(zamwienie, ZamowienieZakupuTO.class));
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    /**
     * Zmienai status zamówienia zakupu o wskazanym Id na Gotowe
     * @param ID Id Zamowienia zakupu
     * @param sessionId Id sesji
     * @return Informacja o powodzeniu operacji
     */
    @Override
    @RequestMapping(value = "/updateStatusZamowienieZakupu/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateStatusZamowienieZakupu(@RequestBody Long ID, @RequestHeader(value = "SessionID") String sessionId) {
        boolean updated = false;
        try {
            zamowienieZakupuUpdateService.updateStatusZamowienia(sessionId, ID);  //.bookArtifactById(sessionId, modelMapper.map(incomingArtifactTo, ArtifactBo.class));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (updated) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(true, HttpStatus.FOUND);
        }
    }

}

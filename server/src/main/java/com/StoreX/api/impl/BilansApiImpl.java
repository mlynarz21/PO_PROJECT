package com.StoreX.api.impl;

import com.StoreX.api.BilansApi;
import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.common.datatypes.to.BilansTO;
import com.StoreX.service.BilansServices.BilansCreationService;
import com.StoreX.service.BilansServices.BilansSearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Date;

/**
 * REST API Bilansu (implementacja)
 */
@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class BilansApiImpl implements BilansApi{

    @Autowired
    private BilansSearchService bilansfindService;

    @Autowired
    private BilansCreationService bilansCreationService;

    private ModelMapper modelMapper = new ModelMapper();

    /**
     * Pobiera bilans z najpóźniejszą datą bilansowaną
     * @param sessionId Id sesji użytkownika wysyłąjącego żądanie
     * @return Bilans z najpóźniejszą datą bilansowaną
     */
    @Override
    @RequestMapping(value = "/getLastBilans/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BilansTO> getLastBilans(@RequestHeader(value = "SessionID") String sessionId){
        BilansBO bilansBO = null;
        try {
            bilansBO = bilansfindService.findLast(sessionId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (bilansBO!=null) {
            BilansTO result = modelMapper.map(bilansBO, BilansTO.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else {
            BilansTO result = null;
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /**
     * Dodaje bilans z aktualną datą jako data wykonania bilansu oraz datą bilansowaną przekazaną w parametrze
     * @param dataBilansowana bilansowana data
     * @param sessionId Id sesji użytkownika wysyłąjącego żądanie
     * @return Informacja o powodzeniu operacji dodawania bilansu
     */
    @Override
    @RequestMapping(value = "/addBilans/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addBilans(@RequestBody Date dataBilansowana, @RequestHeader(value = "SessionID") String sessionId){
        boolean dodano = false;
        try {
            dodano = bilansCreationService.addBilans(sessionId,dataBilansowana);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(dodano, HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity<>(dodano, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(dodano, HttpStatus.OK);
    }
}

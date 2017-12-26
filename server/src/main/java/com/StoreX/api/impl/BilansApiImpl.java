package com.StoreX.api.impl;

import com.StoreX.api.BilansApi;
import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.common.datatypes.to.BilansTO;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.service.BilansService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class BilansApiImpl implements BilansApi{

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @RequestMapping(value = "/getLastBilans/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BilansTO> getLastBilans(@RequestHeader(value = "SessionID") String sessionId){
        BilansBO bilansBO = null;
//        try {
//            bilansBO = searchService.findAllArtifacts(sessionId);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<BilansTO>(HttpStatus.UNAUTHORIZED);
//        }

        BilansTO result = modelMapper.map(bilansBO, BilansTO.class);

        return new ResponseEntity<BilansTO>(result, HttpStatus.OK);

    }

    @Override
    @RequestMapping(value = "/addBilans/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addBilans(@RequestBody Date dataBilansowana, @RequestHeader(value = "SessionID") String sessionId){
        boolean added = false;
//        try {
//            added = bookingService.bookArtifactById(sessionId, modelMapper.map(incomingArtifactTo, ArtifactBo.class));
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
//        }

        if (added) {
            return new ResponseEntity<Boolean>(added, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(added, HttpStatus.FOUND);
        }
    }

    /*
    Created for test purposes, to be removed
     */
    @Autowired
    private BilansService bilansService;
    @Override
    @RequestMapping(value = "/addBilansTest/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addBilansTest(Date dataBilansowana, String sessionId) {
        Bilans b = new Bilans();
        bilansService.saveUser(b);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);

    }

}

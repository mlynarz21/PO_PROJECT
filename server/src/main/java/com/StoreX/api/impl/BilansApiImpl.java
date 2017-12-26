package com.StoreX.api.impl;

import com.StoreX.api.BilansApi;
import com.StoreX.common.datatypes.bo.BilansBO;
import com.StoreX.common.datatypes.to.BilansTO;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.repository.PozycjaBilansuRepository;
import com.StoreX.persistence.repository.TowarRepository;
import com.StoreX.service.BilansService;
import com.StoreX.service.PozycjaBilansuService;
import com.StoreX.service.TowarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Date;

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

        BilansTO result = modelMapper.map(bilansBO, BilansTO.class);
        return new ResponseEntity<BilansTO>(result, HttpStatus.OK);

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

        return new ResponseEntity<Boolean>(bilansBO != null, HttpStatus.OK);
    }

    /*
    Created for test purposes, to be removed
     */

    @Autowired
    TowarService towarService;
    @Autowired
    PozycjaBilansuService pozycjaBilansuService;
    @Override
    @RequestMapping(value = "/addBilansTest/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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

        return new ResponseEntity<Long>(b3.getID(),HttpStatus.OK);

    }

}

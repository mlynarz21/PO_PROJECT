package com.StoreX.api.impl;

import com.StoreX.api.UmieszczenieApi;
import com.StoreX.common.datatypes.bo.UmieszczenieBO;
import com.StoreX.common.datatypes.to.UmieszczenieTO;
import com.StoreX.service.HelperServices.UmieszczenieService;
import com.StoreX.service.UmieszczenieServices.UmieszczenieFindService;
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
public class UmieszczenieApiImpl implements UmieszczenieApi{

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UmieszczenieFindService umieszczenieFindService;

    @Override
    @RequestMapping(value = "/getUmieszczenieTowaru/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UmieszczenieTO>> getUmieszczenieTowaru(@RequestBody Long IDTowaru, @RequestHeader(value = "SessionID") String sessionId){
        List<UmieszczenieBO> umieszczeniaBO = null;
        try {
            umieszczeniaBO = umieszczenieFindService.findAllForTowar(sessionId, IDTowaru);
        } catch (AuthenticationException e) {
            return new ResponseEntity<List<UmieszczenieTO>>(HttpStatus.UNAUTHORIZED);
        }

        List<UmieszczenieTO> results = new ArrayList<>();

        for (UmieszczenieBO umieszczenie : umieszczeniaBO) {
            results.add(modelMapper.map(umieszczenie, UmieszczenieTO.class));
        }

        return new ResponseEntity<List<UmieszczenieTO>>(results, HttpStatus.OK);
    }

}

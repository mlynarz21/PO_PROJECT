package com.StoreX.api.impl;

import com.StoreX.api.PozycjaZamowieniaApi;
import com.StoreX.api.UmieszczenieApi;
import com.StoreX.common.datatypes.bo.KlientBO;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.bo.UmieszczenieBO;
import com.StoreX.common.datatypes.to.KlientTO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.common.datatypes.to.TowarTO;
import com.StoreX.common.datatypes.to.UmieszczenieTO;
import com.StoreX.persistence.entity.Umieszczenie;
import com.StoreX.service.UmieszczenieService;
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
    UmieszczenieService umieszczenieService;
    @Override
    @RequestMapping(value = "/getUmieszczenieTowaru/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UmieszczenieTO>> getUmieszczenieTowaru(@RequestBody Long ID, @RequestHeader(value = "SessionID") String sessionId){
        List<UmieszczenieBO> umieszczeniaBO = null;
        try {
            umieszczeniaBO = umieszczenieService.findAllForTowar(sessionId, ID);
        } catch (AuthenticationException e) {
            return new ResponseEntity<List<UmieszczenieTO>>(HttpStatus.UNAUTHORIZED);
        }

        List<UmieszczenieTO> results = new ArrayList<>();

        for (UmieszczenieBO umieszczenie : umieszczeniaBO) {
            results.add(modelMapper.map(umieszczenie, UmieszczenieTO.class));
        }

        return new ResponseEntity<List<UmieszczenieTO>>(results, HttpStatus.OK);
    }



    @Override
    @RequestMapping(value = "/updateUmieszczenie/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateUmieszczenie(@RequestBody UmieszczenieTO umieszczenie, @RequestHeader(value = "SessionID") String sessionId) {
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

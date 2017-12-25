package com.StoreX.api.impl;

import com.StoreX.api.UmieszczenieApi;
import com.StoreX.api.ZamowienieZakupuApi;
import com.StoreX.common.datatypes.bo.KlientBO;
import com.StoreX.common.datatypes.bo.ZamowienieBO;
import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;
import com.StoreX.common.datatypes.to.KlientTO;
import com.StoreX.common.datatypes.to.UmieszczenieTO;
import com.StoreX.common.datatypes.to.ZamowienieTO;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
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
public class ZamowienieZakupuApiImpl implements ZamowienieZakupuApi{

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @RequestMapping(value = "/getAllZaakceptowane/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZamowienieZakupuTO>> getAllZaakceptowane(@RequestHeader(value = "SessionID") String sessionId){
        List<ZamowienieZakupuBO> zamowieniaBO = null;
//        try {
//            zamowieniaBO = searchService.findAllArtifacts(sessionId);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<List<ZamowienieZakupuTO>>(HttpStatus.UNAUTHORIZED);
//        }

        List<ZamowienieZakupuTO> results = new ArrayList<>();

        for (ZamowienieZakupuBO zamwienie : zamowieniaBO) {
            results.add(modelMapper.map(zamwienie, ZamowienieZakupuTO.class));
        }

        return new ResponseEntity<List<ZamowienieZakupuTO>>(results, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/updateStatusZamowienieZakupu/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateStatusZamowienieZakupu(@RequestBody ZamowienieZakupuTO zamowienieZakupu, @RequestHeader(value = "SessionID") String sessionId) {
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
package com.StoreX.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.AuthenticationException;

import com.StoreX.service.ArtifactBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StoreX.api.ArtifactApi;
import com.StoreX.common.datatypes.bo.ArtifactBo;
import com.StoreX.common.datatypes.to.ArtifactTo;
import com.StoreX.service.ArtifactCreationService;
import com.StoreX.service.ArtifactSearchService;

@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class ArtifactApiImpl implements ArtifactApi {

    @Autowired
    private ArtifactSearchService searchService;

    @Autowired
    private ArtifactCreationService createService;

    @Autowired
    private ArtifactBookingService bookingService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @RequestMapping(value = "/artifacts/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtifactTo>> getAllArtifact(@RequestHeader(value = "SessionID") String sessionId) {
        List<ArtifactBo> artifacts = null;
        try {
            artifacts = searchService.findAllArtifacts(sessionId);
        } catch (AuthenticationException e) {
            return new ResponseEntity<List<ArtifactTo>>(HttpStatus.UNAUTHORIZED);
        }

        List<ArtifactTo> results = new ArrayList<>();

        for (ArtifactBo artifact : artifacts) {
            results.add(modelMapper.map(artifact, ArtifactTo.class));
        }

        return new ResponseEntity<List<ArtifactTo>>(results, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/specifiedArtifacts/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtifactTo>> getSpecifiedArtifact(@RequestBody ArtifactTo incomingArtifactTo, @RequestHeader(value = "SessionID") String sessionId) {
        List<ArtifactBo> artifacts = null;
        try {
            artifacts = searchService.findSpecifiedArtifacts(modelMapper.map(incomingArtifactTo, ArtifactBo.class), sessionId);
        } catch (AuthenticationException e) {
            return new ResponseEntity<List<ArtifactTo>>(HttpStatus.UNAUTHORIZED);
        }

        List<ArtifactTo> results = new ArrayList<>();

        for (ArtifactBo artifact : artifacts) {
            results.add(modelMapper.map(artifact, ArtifactTo.class));
        }

        return new ResponseEntity<List<ArtifactTo>>(results, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/add-artifact/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtifactTo> addNewArtifact(@RequestBody ArtifactTo incomingArtifactTo, @RequestHeader(value = "SessionID") String sessionId) {
        ArtifactBo createdArtifactBo = null;
        try {
            createdArtifactBo = createService.addNewArtifact(sessionId, modelMapper.map(incomingArtifactTo, ArtifactBo.class));
        } catch (AuthenticationException e) {
            return new ResponseEntity<ArtifactTo>(HttpStatus.UNAUTHORIZED);
        }

        if (createdArtifactBo != null) {
            ArtifactTo body = modelMapper.map(createdArtifactBo, ArtifactTo.class);
            return new ResponseEntity<ArtifactTo>(body, HttpStatus.OK);
        } else {
            return new ResponseEntity<ArtifactTo>(HttpStatus.FOUND);
        }
    }

    @Override
    @RequestMapping(value = "/bookArtifact/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> bookArtifactById(@RequestBody ArtifactTo incomingArtifactTo, @RequestHeader(value = "SessionID") String sessionId) {
        boolean isArtifactAvailable = false;
        try {
            isArtifactAvailable = bookingService.bookArtifactById(sessionId, modelMapper.map(incomingArtifactTo, ArtifactBo.class));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
        }

        if (isArtifactAvailable) {
            return new ResponseEntity<Boolean>(isArtifactAvailable, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(isArtifactAvailable, HttpStatus.FOUND);
        }
    }

    @Override
    @RequestMapping(value = "/freeArtifact/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> freeArtifactById(@RequestBody ArtifactTo incomingArtifactTo, @RequestHeader(value = "SessionID") String sessionId) {
        boolean isArtifactAvailable = false;
        try {
            isArtifactAvailable = bookingService.freeArtifactById(sessionId, modelMapper.map(incomingArtifactTo, ArtifactBo.class));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
        }

        if (isArtifactAvailable) {
            return new ResponseEntity<Boolean>(isArtifactAvailable, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(isArtifactAvailable, HttpStatus.FOUND);
        }
    }

    @Override
    @RequestMapping(value = "/borrowArtifact/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> borrowArtifactById(@RequestBody ArtifactTo incomingArtifactTo, @RequestHeader(value = "SessionID") String sessionId) {
        boolean isArtifactAvailable = false;
        try {
            isArtifactAvailable = bookingService.borrowArtifactById(sessionId, modelMapper.map(incomingArtifactTo, ArtifactBo.class));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
        }

        if (isArtifactAvailable) {
            return new ResponseEntity<Boolean>(isArtifactAvailable, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(isArtifactAvailable, HttpStatus.FOUND);
        }
    }

}

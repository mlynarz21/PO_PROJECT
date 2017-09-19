package com.capgemini.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.AuthenticationException;

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

import com.capgemini.api.ArtifactApi;
import com.capgemini.common.datatypes.bo.ArtifactBo;
import com.capgemini.common.datatypes.to.ArtifactTo;
import com.capgemini.service.ArtifactCreationService;
import com.capgemini.service.ArtifactSearchService;

@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class ArtifactApiImpl implements ArtifactApi {

    @Autowired
    private ArtifactSearchService searchService;

    @Autowired
    private ArtifactCreationService createService;

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
            return new ResponseEntity<ArtifactTo>(HttpStatus.BAD_REQUEST);
        }
    }

}

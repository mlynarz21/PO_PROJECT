package com.capgemini.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.common.datatypes.to.ArtifactTo;

/**
 * REST API for the Artifact objects.
 * @author CWOJTOWI
 */
public interface ArtifactApi {

    ResponseEntity<List<ArtifactTo>> getAllArtifact(String sessionId);

    ResponseEntity<ArtifactTo> addNewArtifact(ArtifactTo incomingArtifactTo, String sessionId);


}

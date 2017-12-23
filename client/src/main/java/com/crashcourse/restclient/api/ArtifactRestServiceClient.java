package com.crashcourse.restclient.api;

import java.util.List;

import com.crashcourse.restclient.datatype.enumeration.ArtifactTo;

/**
 * REST client for the artifact REST service.
 *
 * @author Mateusz
 */
public interface ArtifactRestServiceClient {

    /**
     * Gets all artifacts..
     *
     * @return list of artifacts
     */
    List<ArtifactTo> getAllArtifacts();
    
    
    /**
     * 
     * @param artifactTo
     * @return list of artifacts meeting criteria
     */
    List<ArtifactTo> getSpecifiedArtifacts(ArtifactTo artifactTo);
    
    /**
     * Saves a new artifact.
     *
     * @param artifact the artifact to save
     * @return saved artifact
     */
    void addArtifact(ArtifactTo artifact);
    
    void bookArtifact(ArtifactTo artifactTo);
    
    void freeArtifact(ArtifactTo artifactto);
    
    void borrowArtifact(ArtifactTo artifactTo);
}

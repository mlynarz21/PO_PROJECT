package com.crashcourse.restclient.api;

import java.util.List;

import com.crashcourse.restclient.datatype.ArtifactTo;

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
     * Saves a new artifact.
     *
     * @param artifact the artifact to save
     * @return saved artifact
     */
    void addArtifact(ArtifactTo artifact);
}

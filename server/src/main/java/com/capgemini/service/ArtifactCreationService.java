package com.capgemini.service;

import javax.naming.AuthenticationException;

import com.capgemini.common.datatypes.bo.ArtifactBo;

/**
 * Service which is responsible for the logic of the creation process of Artifacts.
 * @author CWOJTOWI
 */
public interface ArtifactCreationService {

    /**
     * Creates and persists a new Artifact.
     * @param sessionId the session id of the user - only a user with a valid session can create new Artifacts
     * @param newArtifact the new Artifact
     * @return the newly created Artifact
     * @throws AuthenticationException if the sessionId is not correct
     */
    ArtifactBo addNewArtifact(String sessionId, ArtifactBo newArtifact) throws AuthenticationException;

}

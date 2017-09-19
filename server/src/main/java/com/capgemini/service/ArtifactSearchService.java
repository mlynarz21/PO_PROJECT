package com.capgemini.service;

import java.util.List;

import javax.naming.AuthenticationException;

import com.capgemini.common.datatypes.bo.ArtifactBo;

/**
 * Service which is responsible for the logic of the search process of Artifacts.
 * @author CWOJTOWI
 */
public interface ArtifactSearchService {

    /**
     * Returns all artifacts from the database.
     * @param sessionId the session id of the user - only a user with a valid session can search Artifacts
     * @return all Artifacts
     * @throws AuthenticationException if the sessionId is not correct
     */
    List<ArtifactBo> findAllArtifacts(String sessionId) throws AuthenticationException;

}

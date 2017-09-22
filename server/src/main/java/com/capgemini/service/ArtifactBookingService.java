package com.capgemini.service;

import com.capgemini.common.datatypes.bo.ArtifactBo;

import javax.naming.AuthenticationException;


public interface ArtifactBookingService {

    boolean bookArtifactById(String sessionId, ArtifactBo artifactBo) throws AuthenticationException;

    boolean freeArtifactById(String sessionId, ArtifactBo artifactBo) throws AuthenticationException;

    boolean borrowArtifactById(String sessionId, ArtifactBo artifactBo) throws AuthenticationException;

}

package com.StoreX.service.impl;

import com.StoreX.common.datatypes.bo.ArtifactBo;
import com.StoreX.persistence.entity.Artifact;
import com.StoreX.persistence.repository.ArtifactRepository;
import com.StoreX.service.ArtifactBookingService;
import com.StoreX.service.AuthorizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.UUID;

@Service
public class ArtifactBookingServiceImpl implements ArtifactBookingService {

    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private AuthorizationService authorizationService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public boolean bookArtifactById(String sessionId, ArtifactBo artifactBo) throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
        }

        Artifact artifactEntity = modelMapper.map(artifactBo, Artifact.class);
            return artifactRepository.bookArtifactById(artifactEntity);

    }

    @Override
    public boolean freeArtifactById(String sessionId, ArtifactBo artifactBo) throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
        }

        Artifact artifactEntity = modelMapper.map(artifactBo, Artifact.class);
        return artifactRepository.freeArtifactById(artifactEntity);

    }

    @Override
    public boolean borrowArtifactById(String sessionId, ArtifactBo artifactBo) throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
        }
        Artifact artifactEntity = modelMapper.map(artifactBo, Artifact.class);
        return artifactRepository.borrowArtifactById(artifactEntity);
    }
}

package com.capgemini.service.impl;

import com.capgemini.common.datatypes.bo.ArtifactBo;
import com.capgemini.persistence.entity.Artifact;
import com.capgemini.persistence.repository.ArtifactRepository;
import com.capgemini.service.ArtifactBookingService;
import com.capgemini.service.AuthorizationService;
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
}

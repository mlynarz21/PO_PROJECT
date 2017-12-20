package com.StoreX.service.impl;

import java.util.UUID;

import javax.naming.AuthenticationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreX.common.datatypes.bo.ArtifactBo;
import com.StoreX.persistence.entity.Artifact;
import com.StoreX.persistence.repository.ArtifactRepository;
import com.StoreX.service.ArtifactCreationService;
import com.StoreX.service.AuthorizationService;

@Service
public class ArtifactCreationServiceImpl implements ArtifactCreationService {

    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private AuthorizationService authorizationService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ArtifactBo addNewArtifact(String sessionId, ArtifactBo newArtifact) throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
        }

        if(validateArtifact(newArtifact)) {
            Artifact artifactEntity = modelMapper.map(newArtifact, Artifact.class);

            artifactRepository.createArtifact(artifactEntity);

            return modelMapper.map(artifactEntity, ArtifactBo.class);
        }
        return null;
    }


    private boolean validateArtifact(ArtifactBo artifact) {
        return isNameValid(artifact.getName()) && artifact.getId() == null;
    }

    private boolean isNameValid(String name) {
        return name != null && !name.isEmpty();
    }
}

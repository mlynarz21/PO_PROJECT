package com.StoreX.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.naming.AuthenticationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreX.common.datatypes.bo.ArtifactBo;
import com.StoreX.persistence.entity.Artifact;
import com.StoreX.persistence.repository.ArtifactRepository;
import com.StoreX.service.ArtifactSearchService;
import com.StoreX.service.AuthorizationService;

@Service
public class ArtifactSearchServiceImpl implements ArtifactSearchService {

    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private AuthorizationService authorizationService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ArtifactBo> findAllArtifacts(String sessionId) throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
        }

        List<Artifact> foundEntities = artifactRepository.findAllArtifacts();
        List<ArtifactBo> artifacts = new ArrayList<ArtifactBo>();

        for(Artifact entity : foundEntities) {
            artifacts.add(modelMapper.map(entity, ArtifactBo.class));
        }

        return artifacts;
    }

    @Override
    public List<ArtifactBo> findSpecifiedArtifacts(ArtifactBo artifactBo, String sessionId) throws AuthenticationException {
        if(!authorizationService.isUserAuthorized(UUID.fromString(sessionId))) {
            throw new AuthenticationException();
        }

        List<Artifact> foundEntities = artifactRepository.findSpecifiedArtifacts(artifactBo);
        List<ArtifactBo> artifacts = new ArrayList<ArtifactBo>();

        for(Artifact entity : foundEntities) {
            artifacts.add(modelMapper.map(entity, ArtifactBo.class));
        }

        return artifacts;
    }

}

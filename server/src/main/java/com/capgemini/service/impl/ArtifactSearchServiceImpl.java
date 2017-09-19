package com.capgemini.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.naming.AuthenticationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.common.datatypes.bo.ArtifactBo;
import com.capgemini.persistence.entity.Artifact;
import com.capgemini.persistence.repository.ArtifactRepository;
import com.capgemini.service.ArtifactSearchService;
import com.capgemini.service.AuthorizationService;

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

}

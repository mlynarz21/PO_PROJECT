package com.capgemini.persistence.repository;

import java.util.List;

import com.capgemini.common.datatypes.bo.ArtifactBo;
import com.capgemini.common.datatypes.enumerations.Category;
import com.capgemini.persistence.entity.Artifact;

/**
 * Repository used for Database actions with the Artifact Entity.
 * @author CWOJTOWI
 */
public interface ArtifactRepository {

    public Artifact findArtifactById(long id);

    public List<Artifact> findAllArtifacts();

    public List<Artifact> findArtifactsByType(Category type);

    public Artifact updateArtifact(Artifact artifact);

    public Artifact createArtifact(Artifact artifact);

    public boolean deleteArtifactById(long id);

    List<Artifact> findSpecifiedArtifacts(ArtifactBo artifactBo);

    boolean bookArtifactById(Artifact artifact);

    boolean freeArtifactById(Artifact artifactEntity);

    boolean borrowArtifactById(Artifact artifactEntity);
}

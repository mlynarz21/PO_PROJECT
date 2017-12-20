package com.StoreX.persistance.repository.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.StoreX.common.datatypes.bo.ArtifactBo;
import com.StoreX.common.datatypes.enumerations.Status;
import com.StoreX.persistence.entity.Artifact;
import com.StoreX.persistence.repository.impl.ArtifactRepositoryImpl;

import junit.framework.Assert;

public class ArtifactRepositoryTest {

	ArtifactRepositoryImpl artifactRepoMock;
	
	
	@Before
	public void set(){
		artifactRepoMock = new ArtifactRepositoryImpl();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkIfSearchWorksForNameStatusTypeAndUsername(){
		
		//given
		ArtifactBo artifact = new ArtifactBo();
		artifact.setName("");
		artifact.setUsername("user");
		artifact.setStatus(Status.BORROWED);
		//when
		List <Artifact> list = artifactRepoMock.findSpecifiedArtifacts(artifact);
		//then
		Assert.assertEquals(list.size(), 1);
		
	}
}

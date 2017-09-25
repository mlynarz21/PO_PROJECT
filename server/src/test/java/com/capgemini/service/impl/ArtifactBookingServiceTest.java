package com.capgemini.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.common.datatypes.bo.ArtifactBo;
import com.capgemini.persistence.repository.impl.UserRepositoryImpl;

public class ArtifactBookingServiceTest {
	
	
	ArtifactBookingServiceImpl artBookSer;
	
	@Before
	public void set(){
		artBookSer = new ArtifactBookingServiceImpl();
	}
	
	@Test
	public void shouldCheckIfBookArtifactByID(){
		
		//given
		String sessionId;
		ArtifactBo artifactBo;
		
		//when
		//boolean result = artBookSer.bookArtifactById(sessionId, artifactBo);
		
		//then
		
	}

}

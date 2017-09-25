package com.capgemini.service.impl;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.naming.AuthenticationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.common.datatypes.bo.ArtifactBo;
import com.capgemini.common.datatypes.enumerations.Category;
import com.capgemini.persistence.entity.Artifact;
import com.capgemini.persistence.repository.ArtifactRepository;
import com.capgemini.persistence.repository.impl.UserRepositoryImpl;
import com.capgemini.service.ArtifactBookingService;
import com.capgemini.service.AuthorizationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtifactBookingServiceTest {
	
	@InjectMocks
	@Autowired
	ArtifactBookingService artBookSer;
	
	@Mock
	private ArtifactRepository artifactRepository;
	
    @Mock
    private AuthorizationService authorizationService;
    
	private ModelMapper modelMapper = new ModelMapper();
	
    private static final Date CREATION_DATE = new GregorianCalendar(2016, 8, 8).getTime();
    private static final String DESCRIPTION = "TEST_DESCRIPTION";
    private static final String NAME = "TEST_NAME";
    private static final String SESSION_ID = UUID.randomUUID().toString();
    
    @Before
	public void set(){
	}
	
	@Test
	public void shouldCheckIfBookArtifactByID() throws AuthenticationException{
		
		//given
		String sessionId=SESSION_ID;
		ArtifactBo artifactBo=prepareValidArtifact();
		Artifact artifactEntity = modelMapper.map(artifactBo, Artifact.class);
		Mockito.when(authorizationService.isUserAuthorized(Matchers.any())).thenReturn(true);
		
		//when
		boolean result = artBookSer.bookArtifactById(sessionId, artifactBo);

		//then
		Mockito.verify(artifactRepository,Mockito.times(1)).bookArtifactById(Matchers.any());
	}
	
	@Test
	public void shouldCheckIfFreeArtifactByID() throws AuthenticationException{
		
		//given
		String sessionId=SESSION_ID;
		ArtifactBo artifactBo=prepareValidArtifact();
		Artifact artifactEntity = modelMapper.map(artifactBo, Artifact.class);
		Mockito.when(authorizationService.isUserAuthorized(Matchers.any())).thenReturn(true);
		
		//when
		boolean result = artBookSer.freeArtifactById(sessionId, artifactBo);

		//then
		Mockito.verify(artifactRepository,Mockito.times(1)).freeArtifactById(Matchers.any());
	}
	
	@Test
	public void shouldCheckIfBorrowArtifactByID() throws AuthenticationException{
		
		//given
		String sessionId=SESSION_ID;
		ArtifactBo artifactBo=prepareValidArtifact();
		Artifact artifactEntity = modelMapper.map(artifactBo, Artifact.class);
		Mockito.when(authorizationService.isUserAuthorized(Matchers.any())).thenReturn(true);
		
		//when
		boolean result = artBookSer.borrowArtifactById(sessionId, artifactBo);

		//then
		Mockito.verify(artifactRepository,Mockito.times(1)).borrowArtifactById(Matchers.any());
	}
	
    private ArtifactBo prepareValidArtifact() {
        ArtifactBo artifact = new ArtifactBo();

        artifact.setCreationDate(CREATION_DATE);
        artifact.setDescription(DESCRIPTION);
        artifact.setName(NAME);
        artifact.setType(Category.PROFESSIONAL);

        return artifact;
    }

}

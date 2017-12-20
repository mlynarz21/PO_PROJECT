package com.StoreX.service.impl;

import java.util.Date;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.naming.AuthenticationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.StoreX.common.datatypes.bo.ArtifactBo;
import com.StoreX.persistence.repository.ArtifactRepository;
import com.StoreX.service.AuthorizationService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtifactSearchServiceTest {
	@InjectMocks
	@Autowired
	ArtifactSearchServiceImpl artifactSearchService;
	
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
	public void shouldCheckIfFindAllArtifacts() throws AuthenticationException{
		
		//given
		String sessionId=SESSION_ID;
		Mockito.when(authorizationService.isUserAuthorized(Matchers.any())).thenReturn(true);
		
		//when
		List<ArtifactBo> result = artifactSearchService.findAllArtifacts(sessionId);

		//then
		Mockito.verify(artifactRepository,Mockito.times(1)).findAllArtifacts();
	}
	


}

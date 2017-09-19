package com.capgemini;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.naming.AuthenticationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.common.datatypes.bo.ArtifactBo;
import com.capgemini.common.datatypes.enumerations.Category;
import com.capgemini.persistence.repository.ArtifactRepository;
import com.capgemini.service.ArtifactCreationService;
import com.capgemini.service.AuthorizationService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateArtifactTest {

    private static final Date CREATION_DATE = new GregorianCalendar(2016, 8, 8).getTime();
    private static final String DESCRIPTION = "TEST_DESCRIPTION";
    private static final String NAME = "TEST_NAME";
    private static final String SESSION_ID = UUID.randomUUID().toString();

    @Autowired
    @InjectMocks
    private ArtifactCreationService serviceToTest;

    @Mock
    private ArtifactRepository repoMock;

    @Mock
    private AuthorizationService authorizationServiceMock;

    @Before
    public void init() {
        Mockito.when(authorizationServiceMock.isUserAuthorized(Mockito.any())).thenReturn(true);
    }

    @Test
	public void shouldCreateObject() {
        // Before
        ArtifactBo artifact = prepareValidArtifact();

        // When
        ArtifactBo createdArtifact = null;
        try {
            createdArtifact = serviceToTest.addNewArtifact(SESSION_ID, artifact);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        // Then
        Mockito.verify(repoMock, Mockito.times(1)).createArtifact(Mockito.any());
        Assert.assertNotNull(createdArtifact);
        Assert.assertEquals(NAME, createdArtifact.getName());
	}

    @Test
    public void shouldSkipObjectCreationBecauseOfSetID() {
        // Before
        ArtifactBo artifact = prepareValidArtifact();
        artifact.setId(123L);

        // When
        ArtifactBo createdArtifact = null;
        try {
            createdArtifact = serviceToTest.addNewArtifact(SESSION_ID, artifact);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        // Then
        Mockito.verify(repoMock, Mockito.never()).createArtifact(Mockito.any());
        Assert.assertNull(createdArtifact);
    }

    @Test
    public void shouldSkipObjectCreationBecauseOfSetIEmptyName() {
        // Before
        ArtifactBo artifact = prepareValidArtifact();
        artifact.setName("");

        // When
        ArtifactBo createdArtifact = null;
        try {
            createdArtifact = serviceToTest.addNewArtifact(SESSION_ID, artifact);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        // Then
        Mockito.verify(repoMock, Mockito.never()).createArtifact(Mockito.any());
        Assert.assertNull(createdArtifact);
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

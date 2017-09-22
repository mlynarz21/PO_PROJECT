package com.capgemini.persistance.repository.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.persistence.entity.User;
import com.capgemini.persistence.repository.impl.UserRepositoryImpl;

public class UserRepositoryTest {
	
	UserRepositoryImpl userRepoMock;
	
	@Before
	public void set(){
		userRepoMock = new UserRepositoryImpl();
	}
	
	@Test
	public void shouldCheckIfRightUserTypeIsReturned(){
		
		//given
        String name1 = "user";
        String name2 = "admin";
		//when
		String type = userRepoMock.getUserType(name1);
		String type2 = userRepoMock.getUserType(name2);
		
		//then
		Assert.assertEquals(type, name1);
		Assert.assertEquals(type2, name2);
	}

}

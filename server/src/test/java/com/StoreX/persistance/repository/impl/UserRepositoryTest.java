package com.StoreX.persistance.repository.impl;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.StoreX.persistence.entity.User;
import com.StoreX.persistence.repository.impl.UserRepositoryImpl;


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
	
	@Test
	public void shouldCheckIfUserCanBeRegistered(){
		
		//given
		User user = new User();
		user.setUsername("user1");
		user.setPassword("haslo");
		
		//when
		boolean result = userRepoMock.register(user);
		
		//then
		Assert.assertEquals(result, true);
		
	}
	
	@Test
	public void shouldCheckIfAlreadyExistUserCanNotBeRegistered(){
		
		//given
		User user = new User();
		user.setUsername("user");
		user.setPassword("haslo");
		
		//when
		boolean result = userRepoMock.register(user);
		
		//then
		Assert.assertEquals(result, false);
		
	}
	
	
	@Test
	public void shouldCheckIfUserCanLogIn(){
		
		//NIE DZIAŁA
		//given
		String username = "user";
		String password = "user";
	
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		
		UUID sessionID = null; 
		

		//when
		UUID result = userRepoMock.login(username, password);
		
		//then
		Assert.assertEquals(result, sessionID);
		
	}

}

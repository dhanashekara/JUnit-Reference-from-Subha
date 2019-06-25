package com.trade.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	@InjectMocks
	User user;
	
	@Test
	public void testUser() {
		user.setUserId(1);
		user.setUserName("user1");
		user.getUserId();
		user.getUserName();
	}
	
}

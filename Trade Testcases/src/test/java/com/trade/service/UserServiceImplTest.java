package com.trade.service;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.trade.model.Stock;
import com.trade.model.User;
import com.trade.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
	UserRepository  userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	static List<User> expectedvalue = null;
	User user = new User(1,"user1");
	
	@BeforeClass
	public static void setup() {
		expectedvalue = new ArrayList<User>();
		User user1 = new User(3,"user3");
		expectedvalue.add(user1);
	}
	
	@Test
	public void testGetUserList() {
		Mockito.when(userRepository.findAll()).thenReturn(expectedvalue);
		List<User> actualValue = userServiceImpl.getUserList();
		Assert.assertEquals(expectedvalue.size(), actualValue.size());
	}
	
	@Test
	public void testGetUser() {
		Mockito.when(userRepository.findByUserId(1)).thenReturn(user);
		User actualValue = userServiceImpl.getUser(1);
		assertNotNull(actualValue);
		assertEquals(user.getUserId(), actualValue.getUserId());
		assertEquals(user.getUserName(),actualValue.getUserName());
	}
	@Test
	public void testSave() {
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User user1 = userRepository.save(user);
		assertEquals(user, user1);
	}
	
	
}

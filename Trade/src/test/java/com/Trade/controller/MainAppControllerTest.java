package com.trade.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.trade.model.User;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(MainAppController.class)
public class MainAppControllerTest {
	
	@Mock
	User user;
	
	private MockMvc mvc;
	 
//	@Test
//	public void testListUser() throws Exception
//	{
//	  mvc.perform(get("/listUser")
//	      .accept(MediaType.APPLICATION_JSON))
//	      .andDo(print())
//	      .andExpect(status().isOk())
//	      .andReturn().getResponse();
//
//	}
	@InjectMocks
	MainAppController mainAppController;
	
	@Before
    public void setup() {
		mainAppController = new MainAppController();
        mvc = MockMvcBuilders.standaloneSetup(mainAppController).build();
    }
	 @Test
	    public void testUser() throws Exception {
	        this.mvc.perform(get("/listUser"))
	        .andExpect(status().isOk());
	    }
	 @Test
	 public void getAllEmployeesAPI() throws Exception
	 {
	   mvc.perform( MockMvcRequestBuilders
	       .get("/listUser")
	       .accept(MediaType.APPLICATION_JSON))
	       .andDo(print())
	       .andExpect(status().isOk())
	       .andExpect(MockMvcResultMatchers.jsonPath("$.user").exists());
	 }
}

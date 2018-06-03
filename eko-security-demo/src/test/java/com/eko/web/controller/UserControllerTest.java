package com.eko.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.eko.security.domain.user.UserQueryCondition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wtx;
	private MockMvc mockMvc;
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wtx).build();
	}
	@Test
	public void whenQuerySuccess() throws Exception{
		UserQueryCondition uc = new UserQueryCondition();
		uc.setAge(2);
		uc.setAgeto(1);
		uc.setUsername("123");
	String result =	mockMvc.perform(get("/user")
				.param("username", uc.getUsername())
				.param("age", String.valueOf(uc.getAge()))
				.param("ageto", String.valueOf(uc.getAgeto()))
				.param("xxx", "yyy")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.length()").value(3))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);;
		//http://www.javadoc.io/doc/com.jayway.jsonpath/json-path/2.4.0
	}
	@Test
	public void whenGenInfoSuccess() throws Exception{
		String result = mockMvc.perform(get("/user/tom").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.username").value("tom"))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);;
	}
	
	@Test
	public void whenGetUserInfo() throws Exception{
		mockMvc.perform(get("/user/a").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void whenCreateSuccess() throws Exception{
		String content = "{\"username\":\"tom\",\"password\":\"123\"}";
		String result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value("3"))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);;
	}
	
	@Test
	public void whenUpdateSuccess() throws Exception{
		String content = "{\"id\":\"1\",\"username\":\"tom\",\"password\":\"123\"}";
		String result = mockMvc.perform(put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value("1"))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);;
	}
	

	@Test
	public void whenDeleteSuccess() throws Exception{
		String content = "{\"id\":\"1\",\"username\":\"tom\",\"password\":\"123\"}";
		String result = mockMvc.perform(delete("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value("1"))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);;
	}
}

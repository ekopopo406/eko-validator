package com.eko.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;

import com.eko.user.api.common.RestResponse;
import com.eko.user.config.GenericRestConfig;

@Repository
public class UserDao {
	@Autowired
	private GenericRestConfig rest;
	public String getUserName(Long id){
		String url = "http://user/getusername?id="+id;
		String directurl = "direct://http://127.0.0.1:8083/getusername?id="+id;
		RestResponse<String> response =  rest.get(url, new ParameterizedTypeReference<RestResponse<String>>(){}).getBody();
		return response.getResult();
	}
}

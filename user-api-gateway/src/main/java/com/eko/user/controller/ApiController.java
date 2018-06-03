package com.eko.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eko.user.api.common.RestResponse;
import com.eko.user.service.UserService;

@RestController
public class ApiController {
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	@Autowired
	private UserService userService;
	@RequestMapping("ekouser1")
	public RestResponse<String> getUserName(long id) {
		logger.info("request comming");
		return RestResponse.success(userService.getUserName(id));
	}
	@RequestMapping("ekouser2")
	public String getUserName(){
		return userService.getUserName(1l);
	}
}

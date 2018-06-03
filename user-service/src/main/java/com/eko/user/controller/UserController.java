package com.eko.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eko.user.common.RestResponse;
import com.eko.user.exception.IllegalParamException;
import com.eko.user.exception.IllegalParamException.exceptionType;
import com.eko.utils.Validator;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Value("${server.port}")
	private Integer port;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@RequestMapping("getusername")	
	public RestResponse<String> getUserName(Long id){
			logger.info("Incoming Request and port is"+port);
			redisTemplate.opsForValue().set("key1", "value1");
			logger.info("redis"+redisTemplate.opsForValue().get("key1"));
			if(Validator.isNull(id)){
				throw new IllegalParamException(exceptionType.WRONG_PAGE_NUM,"worng param");
			}
			return RestResponse.success("test-username"+port);
	}
	//user query
}

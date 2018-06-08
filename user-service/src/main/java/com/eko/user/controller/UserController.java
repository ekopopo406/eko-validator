package com.eko.user.controller;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.wstx.util.StringUtil;
import com.eko.user.common.RestResponse;


@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Value("${server.port}")
	private Integer port;
	//@Autowired
	@Inject
	private StringRedisTemplate redisTemplate;

	@GetMapping("getusername")	
	public RestResponse<List<String>> getUserName(Long id){
			logger.info("Incoming Request and port is"+port);
			redisTemplate.opsForValue().set("key1", "value1");
			logger.info("redis"+redisTemplate.opsForValue().get("key1"));
			
//			if(Validator.isNull(id)){
//				throw new IllegalParamException(exceptionType.WRONG_PAGE_NUM,"worng param");
//			}static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
			List<String> lists = new ArrayList<String>();
			lists.add("1");lists.add("1");lists.add("1");lists.add("1");lists.add("1");
			return RestResponse.success(lists);
	}
	public static void main(String[] args){
		 ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
		 String theformula = "%s+(%s*%s)";
		String ttt= theformula.format(theformula, "1","3","11");
		try {
			System.out.println(ttt);
			Integer ss = (Integer)jse.eval(ttt);
			System.out.println(ss);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//user query
}

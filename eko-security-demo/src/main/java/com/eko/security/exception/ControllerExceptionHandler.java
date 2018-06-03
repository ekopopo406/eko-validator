package com.eko.security.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(UserException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,Object> handlerUserException(UserException ex){
		Map<String,Object> exceptionMap = new HashMap<String,Object>();
		exceptionMap.put("id", ex.getId());
		exceptionMap.put("message", ex.getMessage());
		return exceptionMap;
	}
}

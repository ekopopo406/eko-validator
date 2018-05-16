package com.eko.user.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value=Throwable.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public RestResponse<Object> Handler(HttpServletRequest request,Throwable throwable){
		logger.error(throwable.getMessage(),throwable);
		Object object = throwable;
		RestCode restCode = Exception2CodeRepo.getCode(throwable);
		RestResponse<Object> response = new RestResponse<Object>(restCode.code,restCode.message);
		return response;
	}
}

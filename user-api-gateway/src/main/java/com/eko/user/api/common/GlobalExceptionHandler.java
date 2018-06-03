package com.eko.user.api.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	public RestResponse<Object> Handler(HttpServletRequest request,Throwable throwable){
		logger.error(throwable.getMessage());
		Object object = throwable;
		RestCode restCode = Exception2CodeRepo.getCode(throwable);
		RestResponse<Object> response = new RestResponse<Object>(restCode.code,restCode.message);
		return response;
	}
}

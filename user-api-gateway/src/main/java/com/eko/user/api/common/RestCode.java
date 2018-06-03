package com.eko.user.api.common;

public enum RestCode {
	OK(0,"ok"),
	UNKOWN_ERROR(1,"system service error"),
	WRONG_PAGE(10100,"page does not exist");
	
	public final int code;
	public final String message;
	
	private RestCode(int code,String message){
		this.code=code;
		this.message=message;
	}
}

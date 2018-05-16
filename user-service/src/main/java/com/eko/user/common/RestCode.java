package com.eko.user.common;

public enum RestCode {
	OK(0,"ok"),
	UNKNOWN_ERROR(1,"unknow system service error"),
	WRONG_PAGE(10100,"page does not exist");

	public final int code;
	public final String message;
	
	private RestCode(int code,String message){
		this.code=code;
		this.message=message;
	}
}

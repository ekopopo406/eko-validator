package com.eko.user.exception;

public class IllegalParamException extends RuntimeException implements WithTypeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8828525555605863536L;

	public IllegalParamException(){
		
	}
	private exceptionType type;
	public IllegalParamException(exceptionType type,String msg){
		super(msg);
		this.type=type;
	}
	public exceptionType type(){
		return type;
	}
	public enum exceptionType{
		WRONG_PAGE_NUM,WRONG_TYPE
	}
}

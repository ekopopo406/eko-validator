package com.eko.security.exception;

public class UserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728441276186194076L;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserException(String id){
	
		super("custom user exception");
		this.id=id;
	}
}

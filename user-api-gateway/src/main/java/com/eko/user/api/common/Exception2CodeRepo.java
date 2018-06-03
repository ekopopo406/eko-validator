package com.eko.user.api.common;

import com.eko.utils.Validator;

public class Exception2CodeRepo {
	public static RestCode getCode(Throwable throwable){
		if(Validator.isNull(throwable)){
			return RestCode.UNKOWN_ERROR;
		}
		Object target = throwable;
		return null;
	}
}

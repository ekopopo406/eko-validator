package com.eko.user.common;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.reflect.FieldUtils;
import org.omg.CORBA.UserException;

import com.eko.user.exception.IllegalParamException;
import com.eko.user.exception.WithTypeException;
import com.eko.utils.Validator;
import com.google.common.collect.ImmutableMap;

public class Exception2CodeRepo {
	private static final ImmutableMap<Object,RestCode> MAP = ImmutableMap.<Object, RestCode>builder()
			.put(IllegalParamException.exceptionType.WRONG_PAGE_NUM,RestCode.WRONG_PAGE)
            .put(IllegalStateException.class,RestCode.UNKNOWN_ERROR).build();
//	        .put(UserException.Type.USER_NOT_LOGIN,RestCode.TOKEN_INVALID)
//	        .put(UserException.Type.USER_NOT_FOUND,RestCode.USER_NOT_EXIST)
//	        .put(UserException.Type.USER_AUTH_FAIL,RestCode.USER_NOT_EXIST).build();
	public static RestCode getCode(Throwable throwable){
		if(Validator.isNull(throwable)){
			return RestCode.UNKNOWN_ERROR;
		}
		Object target = throwable;
		if(throwable instanceof WithTypeException){
			Object type = getType(throwable);
			if(Validator.isNull(type)){
				target = type;
			}
		}
		RestCode restCode = MAP.get(target);
		if(Validator.isNotNull(restCode)){
			return restCode;
		}
		Throwable rootCause = ExceptionUtils.getRootCause(throwable);
		if(Validator.isNotNull(rootCause)){
			return getCode(rootCause);
		}
		return RestCode.UNKNOWN_ERROR;
	}
	private static Object getType(Throwable throwable){
		try {
			return FieldUtils.readDeclaredField(throwable, "type",true);
		} catch (IllegalAccessException e) {
			return null;
		}
	}
}

package com.eko.security.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TheValidatorImpl implements ConstraintValidator<EkoValidator,Object>{
	//can aotuwird spring service bean at here 
	@Override
	public void initialize(EkoValidator constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		//System.out.println("this part is your real vali code");
		return false;
	}

}

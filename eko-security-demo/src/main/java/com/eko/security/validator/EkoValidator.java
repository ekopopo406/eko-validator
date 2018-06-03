package com.eko.security.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = TheValidatorImpl.class)
public @interface EkoValidator {
	String message() default "{org.hibernate.validator.constraints.EkoValidator.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

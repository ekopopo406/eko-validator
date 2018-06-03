package com.eko.security.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TimeAspect {
	
	//@Around("execution(* com.eko.web.controller.*.*(..))")
	public Object handlerCOntrollerMethod(ProceedingJoinPoint point) throws Throwable{
		Long start = new Date().getTime();
		Object obj = point.proceed();
		Object[] objarr = point.getArgs();
		for(Object temp:objarr){
			System.out.println("args"+temp);
		}
		System.out.println("TimeAspect "+(new Date().getTime()-start));
		return obj;
	} 
}

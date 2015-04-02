package com.tmall.wireless.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class SleepHelper implements MethodBeforeAdvice,AfterReturningAdvice{

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("afterReturning");
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
	
		System.out.println("before");
	}
}

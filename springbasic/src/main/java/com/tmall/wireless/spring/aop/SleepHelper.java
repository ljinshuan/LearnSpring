package com.tmall.wireless.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SleepHelper{
	
	@Pointcut("execution(* sleep(..))")
	public void sleepPointcut(){}
	
	@Before("sleepPointcut()")
	public void beforeSleep(){
		System.out.println("beforeSleep");
	}
	@AfterReturning("sleepPointcut()")
	public void afterReturn(){
		System.out.println("afterReturn");
	}
}
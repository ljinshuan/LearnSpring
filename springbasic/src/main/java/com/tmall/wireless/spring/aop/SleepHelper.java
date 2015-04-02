package com.tmall.wireless.spring.aop;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SleepHelper{
	
	public void sleepPointcut(){}
	
	public void beforeSleep(){
		System.out.println("beforeSleep");
	}
	public void afterReturn(){
		System.out.println("afterReturn");
	}
}
package com.tmall.wireless.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WeaherAspect {
	
	public WeaherAspect() {
		System.out.println("WeaherAspect");
	}
	@Pointcut("execution(* com.tmall.wireless.springbasic.beans.WeatherManager.getWeather(..))")
	public void weaherPointcut(){}
	
	@Before("weaherPointcut() && args(name)")
	public void beforeTest(String name){
		System.out.println("before weaherPointcut"+ name);
	}
	
	
}

package com.tmall.wireless.angel.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAdvice {

	private Logger logger=LoggerFactory.getLogger(CustomAdvice.class);
	
	public void beforeAdvice(JoinPoint joinpoint){
		logger.info(joinpoint.toString());
		logger.info("before");
	}
	
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		logger.info(joinPoint.toLongString());
		
		
		logger.info("after");
		
		return "1234";
	}
	
	public CustomAdvice(){
		
		
	}
}

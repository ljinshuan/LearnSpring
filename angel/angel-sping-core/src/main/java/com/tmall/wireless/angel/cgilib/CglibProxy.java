package com.tmall.wireless.angel.cgilib;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Logger logger=LoggerFactory.getLogger(CglibProxy.class);
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
	
		logger.info("begin invoke");
		
		
		return proxy.invokeSuper(obj, args);
	}
	
	

}

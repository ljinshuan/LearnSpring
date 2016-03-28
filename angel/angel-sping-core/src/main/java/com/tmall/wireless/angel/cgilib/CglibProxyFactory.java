package com.tmall.wireless.angel.cgilib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibProxyFactory {

	
	public static Object getProxyObject(MethodInterceptor interceptor,Class<?> clazz){
		
		Enhancer enhancer=new Enhancer();
		
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(interceptor);
		
		return enhancer.create();
	}
}

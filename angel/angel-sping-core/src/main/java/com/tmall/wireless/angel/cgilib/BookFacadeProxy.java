package com.tmall.wireless.angel.cgilib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookFacadeProxy implements InvocationHandler {

	Logger logger = LoggerFactory.getLogger(BookFacadeProxy.class);

	private Object target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		logger.info("begin proxy method");
		
		logger.info(ToStringBuilder.reflectionToString(target));
		logger.info(ToStringBuilder.reflectionToString(args));

		Object result = method.invoke(target, args);

		logger.info("end proxy method");
		return result;
	}

	public Object bind(Object obj) {
		this.target = obj;

		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

	}
}

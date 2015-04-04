package com.tmall.wireless.spring.data.dao.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
	public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

	public static <T> T getBean(String name){
		return (T)applicationContext.getBean(name);
	}
}

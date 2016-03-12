package com.tmall.wireless.angel.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmall.wireless.angel.MessageRender;

public class App {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-beans.xml");
		MessageRender messageRender = applicationContext.getBean("messageRender", MessageRender.class);
		messageRender.render();
		
		
	}
}

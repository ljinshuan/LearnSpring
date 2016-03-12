package com.tmall.wireless.angel.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmall.wireless.angel.MessageRender;

public class App {

	
	
	public static void main(String[] args) {

		test1();
		//test2();
		
		
	}

	private static void test2(){
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		MessageRender messageRender = context.getBean("messageRender", MessageRender.class);
		messageRender.render();
	}
	private static void test1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-beans.xml");
		MessageRender messageRender = applicationContext.getBean("messageRender", MessageRender.class);
		messageRender.render();
	}
}

package com.tmall.wireless.spring.aop;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AOPTest {
private static final String XMLPATH="spring/applicationContext.xml";
	
	private static ApplicationContext applicationContext;
	@BeforeClass
	public static void beforeTest(){
		applicationContext=new ClassPathXmlApplicationContext(XMLPATH);
	}
	@Test
	public void test() {
		Sleepable sleeper=(Sleepable)applicationContext.getBean("human");
		sleeper.sleep();
	}
}

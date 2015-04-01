package com.tmall.wireless.springbasic;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmall.wireless.springbasic.beans.WeatherManager;
import com.tmall.wireless.springbasic.codeconfig.AppConfig;

public class JavaCodeAppContextTest {

	private static final String XMLPATH="spring/applicationContext.xml";
	
	private static ApplicationContext applicationContext;
	@BeforeClass
	public static void beforeTest(){
		applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		
	}
	@Test
	public void test() {
		WeatherManager manager=applicationContext.getBean(WeatherManager.class);
		
		manager.getWeather("gerg");
	}

}
package com.tmall.wireless.springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmall.wireless.springbasic.beans.WeatherInterface;

/**
 * Hello world!
 *
 */
public class App {
	private static final String XMLPATH="spring/applicationContext.xml";
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(XMLPATH);
		
		WeatherInterface weatherInterface=(WeatherInterface)applicationContext.getBean("weatherInterface");
		String result=weatherInterface.getWeahterInfo("ljinshuan");
		System.out.println(result);
	}
}

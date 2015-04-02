package com.tmall.wireless.springbasic;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmall.wireless.springbasic.beans.WeatherManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring/applicationContext.xml")
public class SpringIntergrationTest {
	
	@Resource
	private WeatherManager weatherManager;
	
	@Test
	public void test(){
		weatherManager.getWeather("ger");
	}
}

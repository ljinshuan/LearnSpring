package com.tmall.wireless.spring.data.dao.jdbc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmall.wireless.spring.data.dao.CityDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class CityDaoImplTest {

	@Resource(name="jdbcCityDao")
	private  CityDAO cityDAO;
	
	@BeforeClass
	public static void beforeClass(){
		//cityDAO=ApplicationContextUtils.getBean("jdbcCityDao");
		
	}
	@Test
	public void testGetCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCitys() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCount() {
		int result=cityDAO.getCount();
		System.out.println(result);
	}

}

package com.tmall.wireless.spring.data.dao.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmall.wireless.spring.data.dao.CityDAO;
import com.tmall.wireless.spring.data.model.CityDO;

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
		CityDO cityDO=cityDAO.getCity(10);
		System.out.println(cityDO);
	}

	@Test
	public void testGetCitys() {
		List<CityDO> cityDOs=cityDAO.getCitys();
		for (CityDO cityDO : cityDOs) {
			System.out.println(cityDO);
		}
		
	}

	@Test
	public void testGetCount() {
		int result=cityDAO.getCount();
		System.out.println(result);
	}
	@Test
	public void testGetCountByCode(){
		int result=cityDAO.getCountByCountryCode("AFG");
		System.out.println(result);
	}
	@Test
	public void testBatchUpdate(){
		cityDAO.batchUpdate();
	}
	@Test
	public void testInsert(){
		 int result=cityDAO.insert();
		 System.out.println(result);
	}

}

package com.tmall.wireless.spring.data.dao.ibatis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmall.wireless.spring.data.dao.CityDAO;
import com.tmall.wireless.spring.data.model.CityDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class CityDaoImplTest {
	@Resource(name="ibatisCityDao")
	private  CityDAO cityDAO;
	
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
		 long start=System.currentTimeMillis();
		 int n=1000;
		 while(n-->0){
			 int result=cityDAO.insert();
			// System.out.println(result);
		 }
		 long end=System.currentTimeMillis();
		 System.out.println(end-start);
		
	}
}

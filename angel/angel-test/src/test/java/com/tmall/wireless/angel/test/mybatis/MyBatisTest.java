package com.tmall.wireless.angel.test.mybatis;

import com.google.common.collect.Maps;

import com.tmall.wireless.angel.AngelStringUtils;
import com.tmall.wireless.angel.dao.CityDAO;
import com.tmall.wireless.angel.dao.CityMapper;
import com.tmall.wireless.angel.dataobject.CityDO;
import com.tmall.wireless.angel.test.BaseTest;

import org.junit.Test;

import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by jinshuan.li on 2016/8/13.
 */
public class MyBatisTest extends BaseTest {

	@Resource
	private CityMapper cityMapper;

	@Resource
	private CityDAO  cityDAO;

	@Test
	public void testGetCity() {
		CityDO cityDO = cityMapper.getCityById(1L);

		logger.info(AngelStringUtils.toString(cityDO));
	}

	@Test
	public void testGetByName(){
		Map<String,Object> params= Maps.newHashMap();
		params.put("name","Kabul");
		CityDO cityDO= cityMapper.getCityByName(params);

		logger.info(AngelStringUtils.toString(cityDO));
	}

	@Test
	public void testsessionGetByName(){

		CityDO cityDO = cityDAO.getById(1L);
		logger.info(AngelStringUtils.toString(cityDO));

		cityDO=cityDAO.getByName("Kabul");
		logger.info(AngelStringUtils.toString(cityDO));
	}


}

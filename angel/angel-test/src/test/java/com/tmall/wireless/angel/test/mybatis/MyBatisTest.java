package com.tmall.wireless.angel.test.mybatis;

import com.tmall.wireless.angel.AngelStringUtils;
import com.tmall.wireless.angel.dao.CityMapper;
import com.tmall.wireless.angel.dataobject.CityDO;
import com.tmall.wireless.angel.test.BaseTest;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by jinshuan.li on 2016/8/13.
 */
public class MyBatisTest extends BaseTest {

	@Resource
	private CityMapper cityDAO;

	@Test
	public void testGetCity() {
		CityDO cityDO = cityDAO.getCityById(1L);

		logger.info(AngelStringUtils.toString(cityDO));
	}
}

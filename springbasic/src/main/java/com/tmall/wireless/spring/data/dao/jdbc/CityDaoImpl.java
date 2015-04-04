package com.tmall.wireless.spring.data.dao.jdbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tmall.wireless.spring.data.dao.CityDAO;
import com.tmall.wireless.spring.data.model.CityDO;

@Repository("jdbcCityDao")
public class CityDaoImpl implements CityDAO {


	@Resource
	private JdbcTemplate jdbcTemplate;
	public CityDO getCity(int id) {
		
		return null;
	}

	public List<CityDO> getCitys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getCount() {
		String sql="select count(*) from city";
		Integer result=jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

}

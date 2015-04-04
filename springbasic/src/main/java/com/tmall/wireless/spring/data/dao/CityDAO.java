package com.tmall.wireless.spring.data.dao;

import java.util.List;

import com.tmall.wireless.spring.data.model.CityDO;

public interface CityDAO {
	
	public CityDO getCity(int id);
	public List<CityDO> getCitys();
	public int getCount();
}

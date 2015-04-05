package com.tmall.wireless.spring.data.dao.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.tmall.wireless.spring.data.dao.CityDAO;
import com.tmall.wireless.spring.data.model.CityDO;

@Repository("ibatisCityDao")
public class CityDAOImpl extends SqlMapClientDaoSupport implements CityDAO {

	@Override
	public CityDO getCity(int id) {
		return (CityDO) getSqlMapClientTemplate().queryForObject(
				"city.getCity", id);
	}

	@Override
	public List<CityDO> getCitys() {
		return (List<CityDO>) getSqlMapClientTemplate().queryForList(
				"city.getCitys", 10);

	}

	@Override
	public int getCount() {
		SqlMapClientTemplate template = getSqlMapClientTemplate();
		return (int) template.queryForObject("city.getCount");
	}

	@Override
	public int getCountByCountryCode(String code) {
		return (int) getSqlMapClientTemplate().queryForObject(
				"city.getCountByCountryCode", code);
	}

	@Override
	public int insert() {
		CityDO cityDO = new CityDO();

		cityDO.setName("Kabul");
		cityDO.setCountryCode("AFG");
		cityDO.setDistrict("Kabul");
		cityDO.setPopulation(123);
		int result = 0;
		try {
			result = (int) getSqlMapClient().insert("city.insert", cityDO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void batchUpdate() {

		long start = System.currentTimeMillis();
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try {

			sqlMapClient.startBatch();
			for (int i = 0; i < 1000; i++) {
				CityDO cityDO = new CityDO();

				cityDO.setName("Kabul");
				cityDO.setCountryCode("AFG");
				cityDO.setDistrict("Kabul");
				cityDO.setPopulation(123);
				getSqlMapClientTemplate().insert("city.insertBatch", cityDO);
			}
			sqlMapClient.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}

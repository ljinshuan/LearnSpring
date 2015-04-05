package com.tmall.wireless.spring.data.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tmall.wireless.spring.data.dao.CityDAO;
import com.tmall.wireless.spring.data.model.CityDO;

@Repository("jdbcCityDao")
public class CityDAOImpl implements CityDAO {


	@Resource
	private JdbcTemplate jdbcTemplate;
	private CityRowMapper cityRowMapper=new CityRowMapper();
	public CityDO getCity(int id) {
		String sql="select * from city where id=?";
		return jdbcTemplate.queryForObject(sql, cityRowMapper,id);
	}

	public List<CityDO> getCitys() {
		String sql="select * from city where id < ?";
		return jdbcTemplate.query(sql, cityRowMapper,10);
		
	}
	
	@Override
	public int getCount() {
		String sql="select count(*) from city";
		Integer result=jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

	@Override
	public int getCountByCountryCode(String code) {
		String sql="select count(*) from city where CountryCode = ?";
		Integer result=jdbcTemplate.queryForObject(sql, Integer.class,code);
		return result;
	}
	@Override
	public void batchUpdate() {
		String sql="insert into city  (Name,CountryCode,District,Population) values (?,?,?,?)";
		int [] result=jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, "Kabul");
				ps.setString(2, "AFG");
				ps.setString(3, "Kabol");
				ps.setInt(4, 178000);
			}
			
			@Override
			public int getBatchSize() {
				
				return 4;
			}
		});
		System.out.println(result);
		
	}
	@Override
	public int insert() {
		String sql="insert into city  (Name,CountryCode,District,Population) values (?,?,?,?)";
		KeyHolder keyHolder=new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps=con.prepareStatement(sql,new String[]{"ID"});
				ps.setString(1, "Kabul");
				ps.setString(2, "AFG");
				ps.setString(3, "Kabol");
				ps.setInt(4, 178000);
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

}
class CityRowMapper implements RowMapper<CityDO>{

	@Override
	public CityDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CityDO cityDO=new CityDO();
		cityDO.setId(rs.getInt("ID"));
		cityDO.setName(rs.getString("Name"));
		return cityDO;
	}
	
}

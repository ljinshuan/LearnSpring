package com.tmall.wireless.angel.dao;

import com.tmall.wireless.angel.dataobject.CityDO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by jinshuan.li on 2016/8/14.
 */

@Repository
public class CityDAO {

    private static final String NameSpace="com.tmall.wireless.angel.dao.CityMapper.";
	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlSession;

	public CityDO getById(long id) {
		return sqlSession.selectOne(NameSpace+"getCityById", id);
	}

    public CityDO getByName(String name){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("name",name);
        return sqlSession.selectOne(NameSpace+"getCityByName",params);
    }

}

package com.tmall.wireless.angel.dao;

import com.tmall.wireless.angel.dataobject.CityDO;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by jinshuan.li on 2016/8/13.
 */
@Repository
public interface CityMapper {

    CityDO getCityById(long id);

    CityDO getCityByName(Map<String,Object> param);
}

package com.tmall.wireless.angel.dao;

import com.tmall.wireless.angel.dataobject.CityDO;

import org.springframework.stereotype.Repository;

/**
 * Created by jinshuan.li on 2016/8/13.
 */
@Repository
public interface CityMapper {

    CityDO getCityById(long id);
}

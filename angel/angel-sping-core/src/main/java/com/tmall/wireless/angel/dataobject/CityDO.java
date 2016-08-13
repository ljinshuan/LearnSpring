package com.tmall.wireless.angel.dataobject;

import java.io.Serializable;

/**
 * Created by jinshuan.li on 2016/8/13.
 */
public class CityDO implements Serializable{


    private static final long serialVersionUID = -4437950879468201439L;


    private long id;

    private String name;

    private String countryCode;

    private String district;

    private int population;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

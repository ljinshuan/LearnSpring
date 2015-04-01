package com.tmall.wireless.springbasic.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherInterfaceImpl implements WeatherInterface {
	
	
	@Autowired
	private WeatherService weatherService;
	
	
	public String getWeahterInfo(String cityCode) {
		weatherService.getWeather(cityCode);
		return cityCode+"：晴";
	}
}

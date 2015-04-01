package com.tmall.wireless.springbasic.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class WeatherInterfaceImpl implements WeatherInterface {
	
	@Autowired
	private WeatherService weatherService;
	
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	public String getWeahterInfo(String cityCode) {
		weatherService.getWeather(cityCode);
		return cityCode+"：晴";
	}
}

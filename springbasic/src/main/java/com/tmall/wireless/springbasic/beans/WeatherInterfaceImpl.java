package com.tmall.wireless.springbasic.beans;

public class WeatherInterfaceImpl implements WeatherInterface {
	
	private WeatherService weatherService;
	
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	public String getWeahterInfo(String cityCode) {
		weatherService.getWeather(cityCode);
		return cityCode+"：晴";
	}
}

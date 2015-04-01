package com.tmall.wireless.springbasic.beans;


import javax.annotation.Resource;



public class WeatherManager {

	@Resource
	private WeatherInterface weatherInterface;
	
	
	public void getWeather(String name){
		System.out.println("weather manager");
		weatherInterface.getWeahterInfo(name);
	}
}

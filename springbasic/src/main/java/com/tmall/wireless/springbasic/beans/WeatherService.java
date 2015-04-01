package com.tmall.wireless.springbasic.beans;

public class WeatherService {
	
	public WeatherService() {
		System.out.println("construct weather service");
	}
	public void getWeather(String data){
		System.out.println(data+"WeatherService getWeather " );
	}
}

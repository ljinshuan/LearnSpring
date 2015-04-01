package com.tmall.wireless.springbasic.beans;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	
	public WeatherService() {
		System.out.println("construct weather service");
	}
	public void getWeather(String data){
		System.out.println(data+"WeatherService getWeather " );
	}
}

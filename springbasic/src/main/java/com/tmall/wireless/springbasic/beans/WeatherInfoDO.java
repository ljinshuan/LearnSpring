package com.tmall.wireless.springbasic.beans;

public class WeatherInfoDO {
	private String city;
	private String weather;
	private int temperature;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public WeatherInfoDO(String city, String weather, int temperature) {
		super();
		this.city = city;
		this.weather = weather;
		this.temperature = temperature;
	}	
}

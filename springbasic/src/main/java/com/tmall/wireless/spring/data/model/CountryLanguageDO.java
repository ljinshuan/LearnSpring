package com.tmall.wireless.spring.data.model;

public class CountryLanguageDO {
	private String countryCode;
	private String language;
	private boolean isOfficial;
	private float percentage;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public boolean isOfficial() {
		return isOfficial;
	}
	public void setOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
}
package com.tmall.wireless.angel.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tmall.wireless.angel.MessageProvider;

@Service
public class HelloWorldMessageProvider implements MessageProvider {

	@Value("${username}")
	private String userName;
	@Override
	public String getMessage() {
		
		return "Hello World "+ userName;
	}

}

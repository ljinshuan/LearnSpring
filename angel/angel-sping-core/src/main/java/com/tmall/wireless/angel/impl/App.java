package com.tmall.wireless.angel.impl;

import com.tmall.wireless.angel.MessageProvider;
import com.tmall.wireless.angel.MessageRender;

public class App {

	public static void main(String[] args) {
		
		
		MessageRender messageRender=new StandardOutMessageRender();
		
		MessageProvider messageProvider=new HelloWorldMessageProvider();
		
		messageRender.setMessageProvider(messageProvider);
		
		messageRender.render();
	}
}

package com.tmall.wireless.angel.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tmall.wireless.angel.MessageProvider;
import com.tmall.wireless.angel.MessageRender;

@Service("messageRender")
public class StandardOutMessageRender implements MessageRender {

	private static Logger logger=LoggerFactory.getLogger(MessageRender.class);
	
	@Resource
	private MessageProvider messageProvider;

	@Override
	public void render() {
		logger.info(messageProvider.getMessage());
	}

	
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

}

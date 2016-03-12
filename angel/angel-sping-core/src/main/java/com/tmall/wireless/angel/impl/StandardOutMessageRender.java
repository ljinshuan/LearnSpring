package com.tmall.wireless.angel.impl;

import com.tmall.wireless.angel.MessageProvider;
import com.tmall.wireless.angel.MessageRender;

public class StandardOutMessageRender implements MessageRender {

	private MessageProvider messageProvider;

	@Override
	public void render() {

		System.out.println(messageProvider.getMessage());
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

}

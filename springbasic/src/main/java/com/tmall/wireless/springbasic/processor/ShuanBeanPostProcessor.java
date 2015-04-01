package com.tmall.wireless.springbasic.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ShuanBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return null;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return null;
	}

}

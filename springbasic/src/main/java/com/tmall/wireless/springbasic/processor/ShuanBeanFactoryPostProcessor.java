package com.tmall.wireless.springbasic.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ShuanBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory.toString());
	}

}

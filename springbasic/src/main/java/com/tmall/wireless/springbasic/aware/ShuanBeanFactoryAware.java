package com.tmall.wireless.springbasic.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class ShuanBeanFactoryAware implements BeanFactoryAware {

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		
		System.out.println(beanFactory.toString());

	}

}

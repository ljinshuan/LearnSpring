package com.tmall.wireless.angel.aware;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class CustomBeanPostProcessor implements BeanPostProcessor{

	private Logger logger=LoggerFactory.getLogger(CustomBeanPostProcessor.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		
		//logger.info("before beanName {}",beanName);
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		if (!StringUtils.equals("messageRender", beanName)) {
			return bean;
		}
		
		//logger.info("after beanName {}",beanName);
		
		return bean;
	}

}

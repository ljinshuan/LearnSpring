package com.tmall.wireless.angel.aware;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CommonAware implements BeanNameAware,BeanClassLoaderAware,ApplicationContextAware,InitializingBean{

	private Logger logger=LoggerFactory.getLogger(CommonAware.class);
	
	@Override
	public void setBeanName(String name) {
		
		logger.info(name);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
	
		logger.info(classLoader.toString());
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		
		logger.info(applicationContext.toString());
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		
		logger.info("in afterPropertiesSet");
		
	}
	
	@PostConstruct
	public void init(){
		logger.info("in init");
	}

}

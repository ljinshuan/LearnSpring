package com.tmall.wireless.springbasic.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取ApplicatoinContext
 * @author jinshuan.li
 *
 */
public class ShuanApplicationContextAware implements ApplicationContextAware {

	public static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {

		this.applicationContext = applicationContext;
		System.out.println("setApplicationContext");

	}

}

package com.tmall.wireless.springbasic.aware;

import org.springframework.beans.factory.BeanClassLoaderAware;

public class ShuanBeanClassLoaderAware implements BeanClassLoaderAware {

	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println(classLoader.toString());
	}

}

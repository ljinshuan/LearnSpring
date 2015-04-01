package com.tmall.wireless.springbasic.aware;

import org.springframework.beans.factory.BeanNameAware;

public class ShuanBeanNameAware implements BeanNameAware {

	public void setBeanName(String name) {
		System.out.println("BeanNameAware--"+name);
	}

}

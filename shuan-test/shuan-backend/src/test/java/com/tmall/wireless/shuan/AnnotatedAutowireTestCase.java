package com.tmall.wireless.shuan;

import java.lang.reflect.Field;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public abstract class AnnotatedAutowireTestCase {

	private static ApplicationContext applicationContext;

	
	public AnnotatedAutowireTestCase() {
		applicationContext = new ClassPathXmlApplicationContext(
				getConfigurationLocation());
		
		init();
	}

	protected abstract String[] getConfigurationLocation();

	/**
	 * 反射 为testcase设置值
	 */

	private void init() {
		Class<?> clazz = getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			try {
				XAutoWire autoWire = field.getAnnotation(XAutoWire.class);
				if (autoWire == null) {
					continue;
				}
				field.setAccessible(true);
				if (autoWire.value() == XAutoWire.BY_SERVICE) {

					Object obj = getBeanByType(field);
					field.set(this, obj);
				} else {
					// 按照名字查找
					if (StringUtils.isEmpty(autoWire.name())) {
						throw new IllegalArgumentException(field.getName()
								+ "的注解 " + autoWire.annotationType().getName()
								+ " name值不能为空");
					}

					field.set(this, applicationContext.getBean(autoWire.name()));
				}

			} catch (BeansException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}

	private Object getBeanByType(Field field) {
		Object obj=null;
		try {
			obj = applicationContext.getBean(field.getType());
			if (obj != null) {
				return obj;
			}
		} catch (NoSuchBeanDefinitionException e) {
			
		}
		
	
		// 按照类型查
		String[] beanNames = applicationContext.getBeanDefinitionNames();

		obj=null;
		
		for (String name : beanNames) {
			Object tmp = applicationContext.getBean(name);

			if (tmp.getClass().isAssignableFrom(field.getType())) {
				if (obj!=null) {
					throw new NoUniqueBeanDefinitionException(field.getClass(), name); 
				}
				obj=tmp;
			}

		}
		return obj;
	}
}

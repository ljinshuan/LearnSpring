package com.tmall.wireless.shuan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XAutoWire {
	int BY_NAME=1;
	int BY_SERVICE=2;
	int value() default BY_SERVICE;
	String name()  default "";
}

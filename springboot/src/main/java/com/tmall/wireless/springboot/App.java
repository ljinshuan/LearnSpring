package com.tmall.wireless.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 
 * @author jinshuan.li
 *
 */

public class App {
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(AppConfig.class, args);
	}
}

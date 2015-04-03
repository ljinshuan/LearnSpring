package com.tmall.wireless.springboot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.tmall.wireless.springboot")
// @Import(AppConfig.class) 导入其它配置
//@ImportResource("classpath:spring-*.xml")
public class AppConfig {

}

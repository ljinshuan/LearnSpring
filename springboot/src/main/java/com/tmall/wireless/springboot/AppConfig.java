package com.tmall.wireless.springboot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



//@SpringBootApplication 所有配置
@EnableAutoConfiguration
@ComponentScan(basePackages="com.tmall.wireless.springboot")
// @Import(AppConfig.class) 导入其它配置
//@ImportResource("classpath:spring-*.xml")
// @ConfigurationProperties(locations="fef") 属性文件
public class AppConfig {

}

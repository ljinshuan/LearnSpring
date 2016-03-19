package com.tmall.wireless.angel.web.utils;

import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 请求对象帮助类
 * @author jinshuan.li
 *
 */
public class RequestUtils {

	private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

	/**
	 * 打印请求对象的一些基本信息
	 * @param request
	 */
	public static void logRequest(HttpServletRequest request) {

		logger.debug("requestURL:{}", request.getRequestURI());
		logger.debug("method:{}",request.getMethod());
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String key = names.nextElement();
			String value = request.getHeader(key);
			logger.debug("header {}:{}", key, value);
		}
	}

	public static void logResponse(HttpServletResponse response) {
		
		logger.debug("responseStatus:{}",response.getStatus());
	
 		Collection<String> names = response.getHeaderNames();
		for (String key : names) {
			String value = response.getHeader(key);
			logger.debug("response header {}:{}", key, value);
		}
		
	}
}

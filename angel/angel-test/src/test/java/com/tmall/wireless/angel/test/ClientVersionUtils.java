package com.tmall.wireless.angel.test;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对客户端版本处理的工具类
 * 
 * @author xiaofei.hexf 2015年3月25日
 *
 */
public class ClientVersionUtils {
	/**
	 * 版本号的正则表达式
	 */
	private static final Pattern CLIENT_VERSION_PATTERN = Pattern.compile("^([1-9]\\d{0,1}\\.){2,3}[1-9]\\d{0,1}$");
	private static final Logger logger = LoggerFactory.getLogger(ClientVersionUtils.class);

	public static final int MAX_VERSION_PART = 4;

	/**
	 * 用正数表示版本,版本必须是类似xx.yy.zz，xx，xx.yy,xx.yy.zz.aa等形式，不满足要求的返回0
	 * 
	 * @param version
	 *            字符串形式的版本号
	 * @param part
	 *            版本用几部分表示，如果给出个版本不全，则用0补充缺失版本位，例如5.3.0 与 5.3代表的是同一个版本
	 * @return
	 */
	public static int representInInt(String version) {
		version = version.trim();
		if (StringUtils.isBlank(version)) {
			return 0;
		}
		Matcher matcher = CLIENT_VERSION_PATTERN.matcher(version);
		if (!matcher.matches()) {
			return 0;
		}
		String[] parts = version.split("\\.");
		int length = parts.length;
		if (length > MAX_VERSION_PART) {
			return 0;
		}
		int value = 0;
		/**
		 * max space for part, eg: 45.34.30, in this case max space is 2 while
		 * for 344.0.2, the max space is 3
		 */
		int maxSpace = 2;

		for (int i = length; i > 0; i--) {
			int tensPlus = (int) Math.pow(10, maxSpace * (i) - 1);
			int unitsPlus = (int) Math.pow(10, maxSpace * (i) - 2);
			int toPlus = Integer.parseInt(parts[length - i]);
			int tens = toPlus / 10;
			int units = toPlus % 10;
			value += (tensPlus * tens);
			value += (unitsPlus * units);
		}
		return value;

	}

	/**
	 * 把一个字符串版本转换成规范定义的版本号，例如定义版本为3位，则3.4转化为3.4.0
	 * 
	 * @param version
	 * @param part
	 * @return
	 */
	public static String normalize(String version) {
		version = version.trim();
		if (StringUtils.isBlank(version)) {
			throw new IllegalArgumentException("版本号不能为空");
		}
		String[] parts = version.split("\\.");
		if (parts.length > MAX_VERSION_PART) {
			throw new IllegalArgumentException("版本位数不能大于" + MAX_VERSION_PART);
		}

		// if the parts has exactly the same size as part
		if (parts.length == MAX_VERSION_PART) {

			// 去除前导0
			try {
				for (int i = 0; i < parts.length; i++) {
					parts[i] = Integer.valueOf(parts[i]).toString();
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("版本号字符串格式错误");
			}

			return joinVersion(parts);
		}
		// if the parts size is smaller than part defined, auto complete it
		// using "0"
		if (parts.length < MAX_VERSION_PART - 1) {
			// 不到3位
			String[] completeParts = new String[MAX_VERSION_PART - 1];
			for (int i = 0; i < completeParts.length; i++) {
				if (i < parts.length) {
					completeParts[i] = parts[i];
				} else {
					completeParts[i] = "0";
				}
			}
			return joinVersion(completeParts);
		}
		return version;

	}

	

	/**
	 * 把一个数字形式的版本转换成规范定义的版本号，例如定义版本为3位，则99912转化为 9.99.12
	 * 
	 * @param version
	 *            数字形式的版本
	 */
	public static String representInString(int version) {
		int value = version;
		Stack<Integer> values = new Stack<Integer>();
		while (value != 0) {
			// push
			int tmp = value % 100;
			value /= 100;
			values.push(tmp);
		}
		StringBuilder sb = new StringBuilder();
		while (!values.isEmpty()) {
			sb.append(values.pop());
			sb.append(".");
		}
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	private static String joinVersion(String[] parts) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < parts.length; i++) {
			sb.append(parts[i]);
			if (i < parts.length - 1) {
				sb.append(".");
			}
		}
		return sb.toString();
	}

	/**
	 * 验证版本是否合法
	 * 
	 * @param version
	 *            版本
	 * @return
	 */
	public static boolean validate(String version) {
		version = version.trim();
		if (StringUtils.isBlank(version)) {
			return false;
		}
		Matcher matcher = CLIENT_VERSION_PATTERN.matcher(version);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * coronet异常版本号的转化正则表达式
	 */
	private static final Pattern CORONET_CLIENT_VERSION_PATTERN = Pattern.compile("^(\\d{1,2}\\.){2}\\d");

	/**
	 * 将coronet的版本号转换成合法格式，4.6.3001、2.1.1cmcc这种奇怪的版本号，只取前面的4.6.3，2.1.1
	 * 
	 * @param version
	 *            coronet context中版本信息
	 * @return
	 */
	public static String convertCoronetVersion(String version) throws IllegalArgumentException {
		version = version.trim();
		if (StringUtils.isBlank(version)) {
			return version;
		}

		Matcher ruleMatcher = CORONET_CLIENT_VERSION_PATTERN.matcher(version);
		String outputUrl = null;
		if (ruleMatcher.find()) {
			outputUrl = ruleMatcher.group(0);
		} else {
			logger.error("unexpected version found " + version);
			outputUrl = version;
		}

		return outputUrl;
	}

}

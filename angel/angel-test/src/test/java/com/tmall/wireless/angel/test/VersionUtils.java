package com.tmall.wireless.angel.test;


import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class VersionUtils {

	private static Splitter splitter=Splitter.on('.').trimResults().omitEmptyStrings();
	/**
	 * version >= version2
	 * 
	 * @param version
	 * @param version2
	 * @return
	 */
	public static boolean isLateEqualThen(String version, String version2) {
		if (StringUtils.isEmpty(version) || StringUtils.isEmpty(version2)) {
			return false;
		}

		List<String> version1Parts=Lists.newArrayList(splitter.splitToList(version)); 
		List<String> version2Parts=Lists.newArrayList(splitter.splitToList(version2));
		
		if (version1Parts.size()>version2Parts.size()) {
			version2Parts.add("0");
		}else if (version1Parts.size()<version2Parts.size()) {
			version1Parts.add("0");
		}
		
		//计算出一个整数值
		int intVersion1=ClientVersionUtils.parts2Int(version1Parts);
		int intVersion2=ClientVersionUtils.parts2Int(version2Parts);

		return intVersion1 >= intVersion2;
	}

	

	/**
	 * version2<=version
	 * 
	 * @param version
	 * @param version2
	 * @return
	 */
	public static boolean isEarlyEqualThen(String version, String version2) {
		if (StringUtils.isEmpty(version) || StringUtils.isEmpty(version2)) {
			return false;
		}
		
		
		List<String> version1Parts=Lists.newArrayList(splitter.splitToList(version)); 
		List<String> version2Parts=Lists.newArrayList(splitter.splitToList(version2));
		
		if (version1Parts.size()>version2Parts.size()) {
			version2Parts.add("0");
		}else if (version1Parts.size()<version2Parts.size()) {
			version1Parts.add("0");
		}
		
		//计算出一个整数值
		int intVersion1=ClientVersionUtils.parts2Int(version1Parts);
		int intVersion2=ClientVersionUtils.parts2Int(version2Parts);
		return intVersion2<=intVersion1;
	}
}

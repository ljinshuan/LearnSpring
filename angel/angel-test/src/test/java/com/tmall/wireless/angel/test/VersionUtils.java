package com.tmall.wireless.angel.test;

import org.apache.commons.lang3.StringUtils;

public class VersionUtils {

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

		version = toMaxLenght(version);
		version2 = toMaxLenght(version2);

		int intVersion1 = ClientVersionUtils.representInInt(version);
		int intVersion2 = ClientVersionUtils.representInInt(version2);

		return intVersion1 >= intVersion2;
	}

	/**
	 * 补全0
	 * 
	 * @param version
	 * @return
	 */
	private static String toMaxLenght(String version) {

		String[] parts = version.split("\\.");

		int diff = ClientVersionUtils.MAX_VERSION_PART - parts.length;

		if (diff == 0) {
			return version;
		}
		for (int i = 0; i < diff; i++) {
			version += ".0";
		}
		return version;
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
		
		version = toMaxLenght(version);
		version2 = toMaxLenght(version2);
		
		int intVersion1 = ClientVersionUtils.representInInt(version);
		int intVersion2 = ClientVersionUtils.representInInt(version2);
		
		return intVersion2<=intVersion1;
	}
}

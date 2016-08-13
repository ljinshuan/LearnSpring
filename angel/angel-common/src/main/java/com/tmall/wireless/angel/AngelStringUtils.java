package com.tmall.wireless.angel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by jinshuan.li on 2016/8/13.
 */
public class AngelStringUtils {

	public static String toString(Object obj) {
		return ToStringBuilder.reflectionToString(obj, ToStringStyle.JSON_STYLE);
	}
}

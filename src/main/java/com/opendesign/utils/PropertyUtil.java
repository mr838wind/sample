/*
 * Copyright (c) 2016 OpenDesign All rights reserved.
 *
 * This software is the confidential and proprietary information of OpenDesign.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into
 * with OpenDesign.
 */
package com.opendesign.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.slf4j.LoggerFactory;

import com.opendesign.controller.CommonController;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;

/**
 * system.properties
 * 
 * <pre>
 * </pre>
 * 
 * @author hanchanghao
 * @since 2016. 9. 22.
 */
@Slf4j
public class PropertyUtil {

	private static Map<String, String> propertyMap;

	static {

		propertyMap = new HashMap<String, String>();

		ResourceBundle rb = ResourceBundle.getBundle("system");
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			log.debug("System Property Loaded key=[" + key + "] value=[" + value + "]");
			propertyMap.put(key, value);
		}

	}

	public static String getProperty(String key) {
		return propertyMap.get(key);
	}

}

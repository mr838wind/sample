/*
 * Copyright (c) 2016 OpenDesign All rights reserved.
 *
 * This software is the confidential and proprietary information of OpenDesign.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into
 * with OpenDesign.
 */
package com.wdfall.sample;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * sample test
 */
@Controller
@Slf4j
@RequestMapping(value = "/sample")
public class SampleController {

	
	/*****************test*************************/
	/**
	 * view
	 * 
	 * @return
	 */
	@RequestMapping(value = "/jsonTest.do")
	public ModelAndView jsonTestView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/sample/jsonTest");
	}

	/**
	 * ajax
	 * 
	 * @return
	 */
	@RequestMapping(value = "/jsonTest.ajax")
	@ResponseBody
	public List<String> jsonTest(HttpServletRequest request, HttpServletResponse response) {

		log.debug("====jsonTest");
		List<String> result = Arrays.asList("test", "abc", "ggg");

		return result;
	}
	
	/****************test**************************/

}

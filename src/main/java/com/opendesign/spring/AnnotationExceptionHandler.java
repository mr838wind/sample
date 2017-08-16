/*
 * @(#)AnnotationExceptionHandler.java
 * Copyright (c) Windfall Inc., All rights reserved.
 * 2015. 7. 19. - First implementation
 * contact : devhcchoi@gmail.com
 */
package com.opendesign.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 모든 컨트롤러에서 발생하는 exception의 처리를 담당한다.
 * </pre>
 * 
 * @author
 * @email
 * @version 1.0 Since 2015. 7. 19.
 */
@ControllerAdvice
@Slf4j
public class AnnotationExceptionHandler {

	/**
	 * Exception 처리
	 * 
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex) {
		log.error("", ex);

		String uri = request.getRequestURI();

		ModelAndView mv = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String stackTrace = "";
		String resultCode = "9999";
		resultMap.put("result", resultCode);

		if (uri != null && uri.endsWith(".ajax")) {
			// .ajax는 json으로 처리
			stackTrace = ExceptionUtils.getStackTrace(ex);
			resultMap.put("message", stackTrace);
			mv = new JsonModelAndView(resultMap);
		} else {
			// jsp:
			stackTrace = ExceptionUtils.getStackTrace(ex).replaceAll("\\r\\n", "<br/>");
			resultMap.put("message", stackTrace);
			mv = new ModelAndView("error", resultMap);
		}
		return mv;
	}

}

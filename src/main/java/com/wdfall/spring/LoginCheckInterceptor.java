package com.wdfall.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 관리자 세션 체크
 * 
 * @date 2016.02.14
 * @author imDangerous
 * 
 */
@Service
@Slf4j
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * accountName 을 체크하여 세션 체크
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//String cp = request.getContextPath();
		//HttpSession session = request.getSession();
		//String uri = request.getRequestURI();
		
		log.debug(">>> preHandle"); 
		return true;
	}
	

	/**
	 * 컨트롤러가 요청을 처리 한 후에 호출. 컨트롤러 실행 중 예외가 발생하면 실행 하지 않음
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 클라이언트 요청을 처리한 뒤, 즉 뷰를 통해 클라이언트에 응답을 전송한 뒤에 실행 컨트롤러 처리 중 또는 뷰를 생성하는 과정에 예외가 발생해도 실행
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}
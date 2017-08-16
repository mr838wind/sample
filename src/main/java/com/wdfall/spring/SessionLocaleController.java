package com.wdfall.spring;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class SessionLocaleController {
	
	@RequestMapping(value = "/setChangeLocale.do")
	public String changeLocale(@RequestParam(required = false) String locale,	ModelMap map, HttpServletRequest request,	HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Locale locales = null;		

		
		if (locale.matches("ko")) {
			locales = Locale.KOREAN;
		} else {
			locales = Locale.CHINA;
		}

		// 세션에 존재하는 Locale을 새로운 언어로 변경해준다.
		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locales);
		
		// 해당 컨트롤러에게 요청을 보낸 주소로 돌아간다.
		String redirectURL = "redirect:" + request.getHeader("referer");
		return redirectURL;
	}
	
	
	@RequestMapping(value = "/getMessageBundle.do")
    public void getProperties( HttpServletRequest request, HttpServletResponse response) throws IOException {		

		HttpSession session = request.getSession();
		Locale locale = (Locale )session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);		
		
		String target = "";
		if (Locale.KOREAN.equals( locale ) ) {
			target = "ko";
		} else {
			target = "zh_CN";
		}
		
		
         OutputStream outputStream = response.getOutputStream();
         Resource resource = new ClassPathResource("/message/message_" + target + ".properties");
         InputStream inputStream = resource.getInputStream();
          
         List<String> readLines = IOUtils.readLines(inputStream);
         IOUtils.writeLines(readLines, null, outputStream);
          
         IOUtils.closeQuietly(inputStream);
         IOUtils.closeQuietly(outputStream);
    }
	
	
}
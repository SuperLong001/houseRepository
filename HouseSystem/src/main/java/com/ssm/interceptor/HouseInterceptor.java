package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class HouseInterceptor implements HandlerInterceptor{

	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler)
			throws Exception {
		
		
		//SpringMVC：拦截器和过滤器
		//https://www.cnblogs.com/colin220/p/9606412.html
		
		String uri = request.getServletPath();
		System.out.println(uri+"--------");
		
		if(0==(int)request.getSession().getAttribute("CURRENT_USER_ID")){
			
			response.sendRedirect("../pages/index.jsp");
			return false;	
		}
	
		return true;	
	}

	
	
	
}

package org.hnist.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;



public class LoginIntercepter implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
		throws Exception{
		
		
			
			HttpSession session=request.getSession();
			Object obj=session.getAttribute("admin");
			if(obj!=null){
				return true;
			}
			
			System.out.println("拦截器生效");
			response.sendRedirect("/foxjixie/main/login.jsp");
			
		return false;
		
	}
	
}

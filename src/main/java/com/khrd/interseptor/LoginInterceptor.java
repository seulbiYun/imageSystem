package com.khrd.interseptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("interseptor호출 ================");
 		Object loginId = modelAndView.getModel().get("login");
 		if(loginId != null) {
 			//session영역에 Auth키 만들어서 userid값을 넣음
 			System.out.println("로그인 성공");
 			request.getSession().setAttribute("Auth", loginId);
 			response.sendRedirect(request.getContextPath());//home으로 이동
 		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return super.preHandle(request, response, handler);
	}

	

}

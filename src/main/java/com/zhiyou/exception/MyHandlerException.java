package com.zhiyou.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerException implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		ModelAndView mView = new ModelAndView();
		
		if (ex instanceof UnauthenticatedException) {
			//未认证异常
			mView.setViewName("login");
		}else if(ex instanceof UnauthorizedException){
			//未授权异常
			mView.setViewName("error");
		}else{
			//其他异常
			mView.setViewName("error");
		}
		
		return mView;
	}

}

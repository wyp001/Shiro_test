package com.zhiyou.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.pojo.User;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("login")
	public String login(String name,String password,HttpSession session){
		// Subject 主体   ----用户
		Subject subject = SecurityUtils.getSubject();
		//令牌
		AuthenticationToken token = new UsernamePasswordToken(name, password);
		//认证
		try {
			subject.login(token);
		} catch (Exception e) {
			// TODO: handle exception
			//认证失败了
			System.out.println("认证失败了");
			return "login";
		}
		
		//认证成功 
		User user = (User)subject.getPrincipal();
		session.setAttribute("user", user);
		return "home";
	}
	
}

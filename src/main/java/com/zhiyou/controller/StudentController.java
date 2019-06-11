package com.zhiyou.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

	//访问此请求必须有  /student/add 权限
	@RequiresPermissions("/student/add")
	@RequestMapping("add")
	public String add(){
		return "info";
	}
	
	@RequiresPermissions("/student/update")
	@RequestMapping("update")
	public String update(){
		return "info";
	}
	
	@RequiresPermissions("/student/delete")
	@RequestMapping("delete")
	public String delete(){
		return "info";
	}
	
	@RequestMapping("query")
	public String query(){
		return "info";
	}
	
}

package com.zhiyou.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhiyou.dao.UserDao;
import com.zhiyou.pojo.User;

public class SchoolRealm extends AuthorizingRealm{
	
	@Autowired
	UserDao UserDao;

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		System.out.println("授权---校验权限--");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		User user = (User)arg0.getPrimaryPrincipal();
		System.out.println(user);
		//把用户权限添加进来
//		info.addStringPermission("/student/add");
//		info.addStringPermission("/student/update");
		
		
		return info;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("进入认证");
		//根据用户名获取用户数据
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
		//token.getUsername()  获取用户名
		User user = UserDao.getUserByName(token.getUsername());
		if (user == null) {
			return null;
		}
		
		//param1:进行认证的主体对象
		//param2:用户密码(数据库中的密码)
		//param3:String     this.getName():获取当前类名，此处没有获取的类名没有实际作用
		AuthenticationInfo info = 
				new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		
		return info;
	}

}

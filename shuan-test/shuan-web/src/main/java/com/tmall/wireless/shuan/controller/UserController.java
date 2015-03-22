package com.tmall.wireless.shuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmall.wireless.shuan.UserManagerImpl;


@Controller
public class UserController {

	private UserManagerImpl userManager=new UserManagerImpl();
	@RequestMapping(value="/user")
	@ResponseBody
	public String uesrTest(String uid)	{
		
		return userManager.getUser(uid);
	}
}

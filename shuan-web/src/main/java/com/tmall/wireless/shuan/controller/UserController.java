package com.tmall.wireless.shuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmall.wireless.shuan.UserManager;


@Controller
public class UserController {

	private UserManager userManager=new UserManager();
	@RequestMapping(value="/user")
	@ResponseBody
	public String uesrTest(String uid)	{
		
		return userManager.getUser(uid);
	}
}

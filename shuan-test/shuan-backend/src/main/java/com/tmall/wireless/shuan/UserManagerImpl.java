package com.tmall.wireless.shuan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userManager")
public class UserManagerImpl implements UserManager{
	
	@Autowired
	private UserService userService;
	
	@Override
	public String getUser(String uid){
		System.out.println(uid);
		userService.pringUser();
		return "ljinshuan "+uid;
	}
}

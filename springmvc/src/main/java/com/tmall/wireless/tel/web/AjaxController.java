package com.tmall.wireless.tel.web;

import java.util.Date;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/ajax")
public class AjaxController {
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public String testGet(){
		System.out.println("get request");
		return "HelloWorld";
	}
	
	@RequestMapping(value="/get2",method=RequestMethod.GET)
	@ResponseBody
	public String testGetWithParam(String name){
		System.out.println(name);
		return name+new Date().toString();
	}
	
	@RequestMapping(value="/get3",method=RequestMethod.GET)
	@ResponseBody
	public UserForm testGetWithParamAndJson(String name){
		UserForm userForm=new UserForm(name, "ljsljsljs");
		return userForm;
	}
}

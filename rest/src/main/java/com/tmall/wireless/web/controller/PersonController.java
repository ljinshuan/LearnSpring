package com.tmall.wireless.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmall.wireless.web.model.Person;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Person get(@PathVariable int id,HttpServletRequest request){
	
		Person person= new Person("ljinshuan", id);
		return person;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String test(){
		return "test";
	}
}

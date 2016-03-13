package com.tmall.wireless.angel.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmall.wireless.angel.MessageRender;
import com.tmall.wireless.angel.web.vo.Contacter;

@Controller
@RequestMapping("/Home")
public class HomeController {

	@Resource
	private MessageRender messageRender;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Contacter index() {

		messageRender.render();
		Contacter contacter=new Contacter();
		contacter.setUserId(124L);
		contacter.setUserName("ljinshuan");
		
		return contacter;
	}
}

package com.tmall.wireless.angel.web.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.Module;
import com.tmall.wireless.angel.MessageRender;
import com.tmall.wireless.angel.web.vo.Contacter;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource
	private MessageRender messageRender;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Contacter index() {

		messageRender.render();
		Contacter contacter = new Contacter();
		contacter.setUserId(124L);
		contacter.setUserName("ljinshuan");

		return contacter;
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/update.json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contacter update(@RequestBody Contacter contacterRO) {

		logger.debug("get update request {}", contacterRO.toString());
		if (contacterRO.getUserId() == 123) {

			contacterRO.setUserName("adminUpdate-wangdachui");
		}

		return contacterRO;
	}
	
	@RequestMapping(value="/Index",method=RequestMethod.GET)
	public String index(Model model){
		
		model.addAttribute("name", "ljinshuan");
		
		return "index";
		
	}
}

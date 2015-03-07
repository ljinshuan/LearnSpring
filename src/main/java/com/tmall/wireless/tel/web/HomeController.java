package com.tmall.wireless.tel.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("userName", "ljinshuan");
		return "home";
	}
	@RequestMapping(value="/Index",method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("name","ljinshuan");
		return "index";
	}
	@RequestMapping(value="/Index/{id}",method=RequestMethod.GET)
	public String indexId(@PathVariable String id,Model model){
		System.out.println(id);
		return "index";
	}
	//返回表单对象 默认映射的视图文件为home.jsp 参数形式home?name=xxxx
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public UserForm getForm(String name){
		UserForm userForm=new UserForm(name,"ljsljsljs");
		System.out.println(name);
		return userForm;
	}
	
}

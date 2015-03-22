package com.tmall.wireless.shuan.controller;

import java.io.IOException;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	//锟斤拷锟截�锟斤拷锟斤拷 默锟斤拷映锟斤拷锟斤拷锟酵硷拷募锟轿猦ome.jsp 锟斤拷锟斤拷锟斤拷式home?name=xxxx
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public UserForm getForm(String name){
		UserForm userForm=new UserForm(name,"ljsljsljs");
		System.out.println(name);
		return userForm;
	}
	//锟斤拷锟截讹拷锟斤拷为modelmap 默锟斤拷页锟斤拷为ModelMap.jsp 
	//ModelAndView锟缴改憋拷锟斤拷图锟侥硷拷锟斤拷
	@RequestMapping(value="/Index/ModelMap",method=RequestMethod.GET)
	public ModelMap getModelMap(){
		return new ModelMap("username","ljinshuan");
	}
	//只锟斤拷锟斤拷json锟斤拷锟�content-type
	@RequestMapping(value="/addUser",method=RequestMethod.POST,consumes="application/json")
	public void addPet(@RequestBody UserForm userForm,Model model){
		System.out.println(userForm.getUsername());
	}
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	@ResponseBody //锟斤拷示锟斤拷锟截碉拷锟斤拷菁锟絙ody 锟斤拷锟斤拷要jsp页锟斤拷
	public UserForm getUser(String name,Model model){
		System.out.println(name);
		return new UserForm(name,"ljinshuan");
	}
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String test1(@ModelAttribute(value="user") String userName){
		System.out.println(userName);
		return "home";
	}
	@RequestMapping(value="/test2",method=RequestMethod.GET)
	@ResponseBody
	public String test2(){
		return "helloworld";
	}
	
	@RequestMapping(value="/test3",method=RequestMethod.GET)
	@ResponseBody
	public UserForm test3(){
		return new UserForm("ljinshuan", "ljsljsljs");
	}
	@RequestMapping(value="/errortest",method=RequestMethod.GET)
	public String test4() throws IOException{
		throw new IOException("IO异常");
	}
	
	@ExceptionHandler
	public String handleException(IOException ex){
		System.out.println("ex");
		return "error";
	}
}
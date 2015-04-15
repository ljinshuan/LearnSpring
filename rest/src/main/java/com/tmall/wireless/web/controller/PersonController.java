package com.tmall.wireless.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmall.wireless.web.model.Person;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PersonController.class);
	
	private List<Person> persons=Arrays.asList(new Person(1, "ljinshuan", 23),new Person(2, "Shuan", 24));
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Person> query(){
		return persons;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Person get(@PathVariable int id,HttpServletRequest request){
		return persons.get(id-1);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> update(@PathVariable int id,@RequestBody Person person){

		LOGGER.info(person.toString());
		ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable int id){
		
		ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> insert(@RequestBody Person person){
		LOGGER.info(person.toString());
		ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String test(){
		return "test";
	}
}

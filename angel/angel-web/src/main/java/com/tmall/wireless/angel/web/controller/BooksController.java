package com.tmall.wireless.angel.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmall.wireless.angel.service.BookService;

@Controller
public class BooksController {

	@Resource
	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/books")
	public String books(Map<String, Object> context) throws Exception {
		context.put("books", bookService.findBooks());
		return "books";
	}

}

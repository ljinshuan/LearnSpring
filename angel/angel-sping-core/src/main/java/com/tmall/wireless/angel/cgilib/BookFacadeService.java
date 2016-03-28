package com.tmall.wireless.angel.cgilib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookFacadeService {

	private Logger logger = LoggerFactory.getLogger(BookFacadeService.class);

	public String addBook(String bookName) {

		logger.info("addBook :{}", bookName);

		return "add-" + bookName;
	}
}

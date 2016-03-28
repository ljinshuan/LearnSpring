package com.tmall.wireless.angel.cgilib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BookFacade {

	public void addBook();
}

class BookFacadeImpl implements BookFacade{

	Logger logger=LoggerFactory.getLogger(BookFacadeImpl.class);
	
	@Override
	public void addBook() {
		
		logger.info("addBook");
		
	}
	
}


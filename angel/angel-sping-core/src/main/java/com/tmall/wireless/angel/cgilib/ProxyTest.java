package com.tmall.wireless.angel.cgilib;

public class ProxyTest {

	public static void main(String[] args) {

		
		test2();
	}

	
	public static void test2(){
		BookFacadeService bookFacadeService=(BookFacadeService)CglibProxyFactory.getProxyObject(new CglibProxy(), BookFacadeService.class);
		bookFacadeService.addBook("ljinshuan");
	}
	/**
	 * 动态代理测试
	 */
	public static void test1() {

		BookFacadeProxy proxy = new BookFacadeProxy();

		BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());

		bookFacade.addBook();
	}
}

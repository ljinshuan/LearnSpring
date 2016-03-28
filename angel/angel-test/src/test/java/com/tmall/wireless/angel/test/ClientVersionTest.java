package com.tmall.wireless.angel.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientVersionTest {

	@Test
	public void test1() {

		int result = ClientVersionUtils.representInInt("5.12.34");

		assertEquals(result, 51234);
	}

	@Test
	public void test2() {

		int result = ClientVersionUtils.representInInt("05.12.34");

		assertEquals(0, result);

	}

	@Test
	public void test3() {
		int result = ClientVersionUtils.representInInt("5.12.34.1");

		assertEquals(5123401, result);
	}
	
	@Test
	public void test4() {
		int result = ClientVersionUtils.representInInt("5.05.34.1");

		assertEquals(0, result);
	}
	
	@Test
	public void test5() {
		int result = ClientVersionUtils.representInInt("5.5.34.01");

		assertEquals(0, result);
	}
	
	@Test
	public void test6() {
		
		String result=ClientVersionUtils.representInString(5123401);
		assertEquals("5.12.34.1", result);
	}
	
	@Test
	public void test7() {
		
		String result=ClientVersionUtils.representInString(5120310);
		assertEquals("5.12.3.10", result);
	}
	
	@Test
	public void test8(){
		String result=ClientVersionUtils.normalize("5.4");
		assertEquals("5.4.0", result);
	}
	
	@Test
	public void test9(){
		String result=ClientVersionUtils.normalize("5.4.1.3");
		assertEquals("5.4.1.3", result);
	}
	
	@Test
	public void test10(){
		boolean result=VersionUtils.isEarlyEqualThen("5.12.3.4","5.12.3" );
		assertEquals(true, result);
	}
	
	@Test
	public void test11(){
		boolean result=VersionUtils.isEarlyEqualThen("5.1.3.4","5.10.3" );
		assertEquals(false, result);
	}
	
	@Test
	public void test12(){
		boolean result=ClientVersionUtils.validate("1.0.0.0");
		
		assertTrue(result);
		
		result=ClientVersionUtils.validate("1.10.0.1");
		assertTrue(result);
	}
	
	@Test
	public void test13(){
		boolean result=ClientVersionUtils.validate("5.0.0");
		
		assertTrue(result);
		
		
	}

}

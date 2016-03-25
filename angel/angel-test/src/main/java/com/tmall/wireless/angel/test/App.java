package com.tmall.wireless.angel.test;

import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
public class App {
	
	private static CountDownLatch countDownLatch=new CountDownLatch(1);
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World!");
		
		while(true){
			test1();
			Thread.sleep(1000);
		}
		
		
		//countDownLatch.await();
	}
	
	public static void test1(){
		for(int i=0;i<100;i++){
			User user=new User();
		}
		System.gc();
	}
}

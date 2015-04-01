package com.tmall.wireless.spring.spel;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELTest {

	@Test
	public void test() {
		
		ExpressionParser parser=new SpelExpressionParser();
		Expression exp=parser.parseExpression("'Hello World'");
		String message=(String)exp.getValue();
		System.out.println(message);
	}

}

package com.tmall.wireless.angel;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring*.xml" })
public class MessageProviderTest {

	@Resource
	private MessageProvider messageProvider;

	@Test
	public void testGetMessage() {

		assertEquals("", messageProvider.getMessage());
	}

}

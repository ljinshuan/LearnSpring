package com.tmall.wireless.shuan;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;




public class UserManagerTest extends AnnotatedAutowireTestCase {

	@XAutoWire(value=XAutoWire.BY_SERVICE)
	private UserManager userManager;
	
	
	@Test
	public void test() {
		
		
		userManager.getUser("xixi");
	}
	
	@Override
	protected String[] getConfigurationLocation() {
		return new String [] {
				"spring/applicationContext-*.xml"
		};
	}

}

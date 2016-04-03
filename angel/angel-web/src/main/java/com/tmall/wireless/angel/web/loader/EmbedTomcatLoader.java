package com.tmall.wireless.angel.web.loader;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbedTomcatLoader {

	private final static Logger logger = LoggerFactory.getLogger(EmbedTomcatLoader.class);

	private static String workingDir = "D:\\Tomcat";

	private static Tomcat tomcat = null;

	public static void main(String[] args) throws ServletException {
		tomcat = new Tomcat();

		tomcat.setPort(8080);
		tomcat.setBaseDir(workingDir);
		tomcat.getHost().setAppBase(workingDir);
		tomcat.getHost().setAutoDeploy(true);
		tomcat.getHost().setDeployOnStartup(true);

		
		
		
		tomcat.addWebapp("/angel-web", workingDir+"/webapps/angel-web");
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tomcat.getServer().await();
	}
}

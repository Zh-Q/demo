package com.bull.ebiscus.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@WebListener(value = "contextListener")
public class ContextListener implements ServletContextListener {
	private static final Logger log = LoggerFactory
			.getLogger(ContextListener.class);

	public void contextDestroyed(ServletContextEvent arg0) {
		log.error("ContextListener destoryed!");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		log.error("ContextListener initialized!");
	}

}

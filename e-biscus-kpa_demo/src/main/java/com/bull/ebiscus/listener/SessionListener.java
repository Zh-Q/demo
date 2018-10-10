package com.bull.ebiscus.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "SessionListener")
@WebListener(value = "SessionListener")
public class SessionListener implements HttpSessionListener {

	private static final Logger log = LoggerFactory
			.getLogger(SessionListener.class);

	public SessionListener() {
		log.error("SessionListener initialized!");
	}

	public void sessionCreated(HttpSessionEvent se) {
		log.error("session created.");
		HttpSession s = se.getSession();
		log.error("[C] session id -> " + s.getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		log.error("session destroyed.");

		HttpSession s = se.getSession();
		log.error("[D] session id -> " + s.getId());
	}

}

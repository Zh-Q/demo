package com.bull.ebiscus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * This class indicates how to use a web filter
 * 
 * @author qi.zhang
 *
 */
@Order(1)
@Component(value = "LoginFilter")
@WebFilter(filterName = "LoginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {

	private static final Logger log = LoggerFactory
			.getLogger(LoginFilter.class);

	public void destroy() {
		log.error("LoginFilter destoryed!");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		log.error("LoginFilter doFilter!" + req.getRequestURL());
		
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		log.error("LoginFilter inited!");
	}

}

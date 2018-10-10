package com.bull.ebiscus.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bull.ebiscus.entity.Users;
import com.bull.ebiscus.mapper.UserMapper;

/**
 * User controller class
 *
 */
@SpringBootApplication
@RestController
@RequestMapping(path = "/")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserMapper userDao;

	@RequestMapping
	@ResponseBody
	public void init(HttpServletRequest req, HttpServletResponse resp) {
		log.error("init");

		try {
			resp.sendRedirect("index.htm");
		} catch (IOException e) {
			log.error("", e);
		}
	}

	@RequestMapping(path = "welcome")
	@ResponseBody
	public String welcome(@RequestParam String name) {
		log.error("Welcome");
		return "Welcome, " + name + " !";
	}

	@RequestMapping(path = "user/info/{name}")
	@ResponseBody
	public String info(@PathVariable String name) {
		log.error("Welcome");
		
		Users us = userDao.findUserByUserId(name);
		return "Welcome, " + name + " with email " + us.getEmail() + "!";
	}

}

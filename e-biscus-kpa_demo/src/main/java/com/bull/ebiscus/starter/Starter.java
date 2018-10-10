package com.bull.ebiscus.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring boot Application starter
 * 
 * @author qi.zhang
 *
 */
@SpringBootApplication(scanBasePackages = { "com.bull" })
// this annotation will initial all the filters
@ServletComponentScan
@MapperScan("com.bull.ebiscus.mapper")
public class Starter {
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
}

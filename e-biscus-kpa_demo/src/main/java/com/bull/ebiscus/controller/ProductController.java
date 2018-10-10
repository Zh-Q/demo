package com.bull.ebiscus.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bull.ebiscus.entity.Product;
import com.bull.ebiscus.mapper.ProductMapper;

@SpringBootApplication
@RestController
@RequestMapping(path = "/main/pdt")
public class ProductController {

	@Resource
	private ProductMapper pdtDao;
	
	@RequestMapping("/query/{id}")
	@ResponseBody
	public String getPdtById(@PathVariable("id") String id) {
		Product p = pdtDao.getPdtById(id);
		return "" + p.getCmp();
	}
	
	@RequestMapping("/add/{name}")
	@ResponseBody
	@Transactional
	public String addPdt(@PathVariable("name") String name) {
		Product p = new Product();
		
		p.setName(name);
		p.setP_auth_date(new Date());
		p.setP_place_of_origin("中国江苏南京");
		p.setP_remark("creat product " + name + " ok.");
		p.setP_c_id("77DCF13442455543E053E80DB8814FCD");
		
		int i = pdtDao.insert(p);
		
		if(i < 1) {
			return "Create product " + name + " failed.";
		}
		return "Create product " + name + " success.";
	}
}

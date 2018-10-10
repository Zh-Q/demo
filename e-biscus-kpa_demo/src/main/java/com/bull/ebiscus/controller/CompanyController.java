package com.bull.ebiscus.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bull.ebiscus.entity.Company;
import com.bull.ebiscus.entity.Product;
import com.bull.ebiscus.mapper.CompanyMapper;
import com.bull.ebiscus.mapper.ProductMapper;
import com.google.gson.Gson;

@SpringBootApplication
@RestController
@RequestMapping(path = "/main/cmp")
public class CompanyController {

	@Resource
	private CompanyMapper cmpDao;

	@Resource
	private ProductMapper pdtDao;

	@RequestMapping
	@ResponseBody
	public String addCmp(@RequestParam("name") String name) {
		Company c = new Company();
		c.setC_name(name);
		c.setC_legal_person("Zhang, Qi");
		c.setC_create_date(new Date());
		c.setC_expire_date(new Date());
		c.setC_remark("Create " + name + " ok !");

		cmpDao.insert(c);
		return "Create " + name + " ok !";
	}

	@RequestMapping(path = "delete/{id}")
	@ResponseBody
	public String deleteCmp(@PathVariable("id") String id) {
		// get company first
		Company c = cmpDao.getCmpInfo(id);
		if (c == null) {
			return "The company " + id + " is not exist.";
		}

		int i = cmpDao.delete(id);
		return i > 0 ? "Remove company " + c.getC_name() + " success!" : "The company " + id + " is not exist.";
	}

	@RequestMapping("rename/{id}/{name}")
	@ResponseBody
	public String changeCmpName(@PathVariable("id") String id, @PathVariable("name") String name) {

		Company c = cmpDao.getCmpInfo(id);
		if (c == null) {
			return "the given company is not exist.";
		}

		// rename this company
		c.setC_name(name);
		cmpDao.changeCompNameById(c);
		return "Rename company from " + c.getC_name() + " to " + name + " ok !";
	}

	@RequestMapping("/pdt/{id}")
	@ResponseBody
	public String listPdtByCmpId(@PathVariable("id") String id) {
		List<Product> ps = pdtDao.getPdtByCmpId(id);

		if (ps == null) {
			return "no products found.";
		}

		return new Gson().toJson(ps);
	}
}

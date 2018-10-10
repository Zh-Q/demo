package com.bull.ebiscus.entity;

import java.util.Date;
import java.util.List;

/**
 * The Company class
 * 
 * @author qi.zhang
 *
 */
public class Company {

	private String c_id;

	private String c_name;

	private String c_remark;

	private Date c_create_date;

	private Date c_expire_date;

	private String c_legal_person;

	private List<Product> products;

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_remark() {
		return c_remark;
	}

	public void setC_remark(String c_remark) {
		this.c_remark = c_remark;
	}

	public Date getC_create_date() {
		return c_create_date;
	}

	public void setC_create_date(Date c_create_date) {
		this.c_create_date = c_create_date;
	}

	public Date getC_expire_date() {
		return c_expire_date;
	}

	public void setC_expire_date(Date c_expire_date) {
		this.c_expire_date = c_expire_date;
	}

	public String getC_legal_person() {
		return c_legal_person;
	}

	public void setC_legal_person(String c_legal_person) {
		this.c_legal_person = c_legal_person;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String toString() {
		return " [" + this.c_id + ", " + this.c_name + ", " + this.c_remark + ", " + this.c_legal_person + "] ";
	}
}
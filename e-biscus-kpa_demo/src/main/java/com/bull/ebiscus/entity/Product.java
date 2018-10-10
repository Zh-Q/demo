package com.bull.ebiscus.entity;

import java.util.Date;

/**
 * The product class
 * 
 * @author qi.zhang
 *
 */
public class Product {

	private String p_id;

	private String name;

	private String p_c_id;

	private String p_place_of_origin;

	private Date p_auth_date;

	private String p_remark;

	private Company cmp;

	public final String getP_id() {
		return p_id;
	}

	public final void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getP_c_id() {
		return p_c_id;
	}

	public final void setP_c_id(String p_c_id) {
		this.p_c_id = p_c_id;
	}

	public final String getP_place_of_origin() {
		return p_place_of_origin;
	}

	public final void setP_place_of_origin(String p_place_of_origin) {
		this.p_place_of_origin = p_place_of_origin;
	}

	public final Date getP_auth_date() {
		return p_auth_date;
	}

	public final void setP_auth_date(Date p_auth_date) {
		this.p_auth_date = p_auth_date;
	}

	public final String getP_remark() {
		return p_remark;
	}

	public final void setP_remark(String p_remark) {
		this.p_remark = p_remark;
	}

	public final Company getCmp() {
		return cmp;
	}

	public final void setCmp(Company cmp) {
		this.cmp = cmp;
	}
}
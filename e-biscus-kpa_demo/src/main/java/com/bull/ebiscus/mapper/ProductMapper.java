package com.bull.ebiscus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.bull.ebiscus.entity.Product;

@Mapper
public interface ProductMapper {

	@Select("select c.c_id, c.c_name, c.c_remark,c.c_expire_date,c.c_create_date,c.c_legal_person, p.p_id,p.p_name,p.p_place_of_origin,p.p_auth_date,p.p_remark from company c, product p where c.c_id = p.p_c_id and p.p_id=#{id, jdbcType=VARCHAR}")
	@Results({ 
		@Result(property = "p_id", column = "p_id", id = true), 
		@Result(property = "p_name", column = "name"),
		@Result(property = "cmp.c_id", column = "c_id"), @Result(property = "cmp.c_name", column = "c_name"),
		@Result(property = "cmp.c_remark", column = "c_remark"),
		@Result(property = "cmp.c_expire_date", column = "c_expire_date"),
		@Result(property = "cmp.c_create_date", column = "c_create_date"),
		@Result(property = "cmp.c_legal_person", column = "c_legal_person") 
	})
	Product getPdtById(@Param("id") String id);

	@Insert("insert into product(p_id, p_name, p_place_of_origin, p_auth_date, p_remark, p_c_id) values(#{p_id}, #{name}, #{p_place_of_origin}, #{p_auth_date, jdbcType=DATE}, #{p_remark}, #{p_c_id})")
	@SelectKey(before = true, keyProperty = "p_id", resultType = String.class, statement = { "select sys_guid() from dual " })
	int insert(Product p);
	
	@Select("select p.p_id,p.p_name,p.p_place_of_origin,p.p_auth_date,p.p_remark from company c, product p where c.c_id = p.p_c_id and c.c_id=#{id, jdbcType=VARCHAR}")
	@Results({
		@Result(column="p_name", property="name")
	})
	List<Product> getPdtByCmpId(@Param("id") String id);
}

package com.bull.ebiscus.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bull.ebiscus.entity.Company;

@Mapper
public interface CompanyMapper {

	/**
	 * To annotation Insert can be used just like the following
	 * 
	 * To annotation SelectKey can be used when something needed to do first or
	 * later, such as generate the primary id of the table
	 * 
	 * @param comp
	 * @return
	 */
	@Insert("insert into Company(c_id,C_NAME,C_REMARK,C_CREATE_DATE,C_EXPIRE_DATE,C_LEGAL_PERSON) values(#{c_id,jdbcType=VARCHAR}, #{c_name,jdbcType=VARCHAR},#{c_remark,jdbcType=VARCHAR},#{c_create_date,jdbcType=DATE},#{c_expire_date,jdbcType=DATE},#{c_legal_person,jdbcType=VARCHAR})")
	@SelectKey(statement = { "select sys_guid() from dual" }, keyProperty = "c_id", resultType = String.class, before = true)
	int insert(Company comp);

	@Delete("delete from company where c_id=#{id, jdbcType=VARCHAR}")
	int delete(@Param("id") String id);
	
	/**
	 * To annotation Update is sample, do not need to do something
	 * 
	 * @param cmp
	 * @return
	 */
	@Update("update Company set c_name=#{c_name, jdbcType=VARCHAR} where c_id=#{c_id, jdbcType=VARCHAR}")
	int changeCompNameById(Company cmp);

	/**
	 * To annotation Update is sample, do not need to do something
	 * 
	 * @param id
	 * @return
	 */
	@Select("select c_id, c_name, c_remark, c_create_date, c_expire_date, c_legal_person from company where c_id=#{id, jdbcType=VARCHAR}")
	Company getCmpInfo(@Param("id") String id);
}

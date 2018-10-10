package com.bull.ebiscus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bull.ebiscus.entity.Users;

@Mapper
public interface UserMapper {

	@Select("SELECT userid, email FROM users WHERE userid = #{userId}")
    Users findUserByUserId(@Param("userId") String userId);
}

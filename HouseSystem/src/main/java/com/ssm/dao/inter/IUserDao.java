package com.ssm.dao.inter;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ssm.bean.UserInfo;

@Repository
public interface IUserDao {
	
	@Insert("insert into user_info(user_name,user_pass) values(#{userName},#{userPass})")
	public void saveUser(UserInfo userInfo);
	
	
	@Select("select user_id from user_info where user_name=#{userName} and user_pass=#{userPass}")
	public int loginSystem(UserInfo userInfo);
	
}

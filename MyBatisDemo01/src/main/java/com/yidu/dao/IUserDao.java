package com.yidu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yidu.bean.QueryVo;
import com.yidu.bean.UserInfo;

public interface IUserDao {
	
	
	public List<UserInfo> queryAll();
	
	public void saveUser(UserInfo userInfo);
	
	public void updateUser(UserInfo userInfo);
	
	public void deleteUser(int user_id);
	
	public List<UserInfo> fuzzyQuery(String user_name);
	
	public int queryTotal();
	
	public String queryVo(QueryVo queryVo);
	
	/**
	 * MyBatis动态sql写法
	 * @return
	 */
	public List<UserInfo> inquireSQL(UserInfo userInfo);
}

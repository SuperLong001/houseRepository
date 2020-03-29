package com.ssm.service.inter;

import com.ssm.bean.UserInfo;

public interface IUserService {
	
	public void saveUser(UserInfo userInfo);
	
	public int loginSystem(UserInfo userInfo);
}

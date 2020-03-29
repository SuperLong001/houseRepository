package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.bean.UserInfo;
import com.ssm.dao.inter.IUserDao;
import com.ssm.service.inter.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void saveUser(UserInfo userInfo) {
		userDao.saveUser(userInfo);
	}

	public int loginSystem(UserInfo userInfo) {
		return userDao.loginSystem(userInfo);
	}

}

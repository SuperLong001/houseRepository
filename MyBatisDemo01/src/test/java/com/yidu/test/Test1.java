package com.yidu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yidu.bean.QueryVo;
import com.yidu.bean.UserInfo;
import com.yidu.dao.IUserDao;

public class Test1{
	
	InputStream in;
	SqlSession sqlSession;
	IUserDao userDao;
	
	@Before
	public void init(){
		 try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		 sqlSession = sqlSessionFactory.openSession();
		
		 userDao = sqlSession.getMapper(IUserDao.class);
	}
	
	
	@After
	public void destroy(){
		sqlSession.commit();
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSession.close();
	}
	
	
	@Test
	public  void qureyAll(){
		
		List<UserInfo> userInfos = userDao.queryAll();
		
		for (UserInfo userInfo : userInfos) {
			System.out.println(userInfo.getUserName()+"\t"+userInfo.getUserPass());
		}
	
	}
	
	
	@Test
	public void saveUser(){
		UserInfo userInfo = new UserInfo(0,"小宝","123");
		
		System.out.println(userInfo.getUserId());
		userDao.saveUser(userInfo);
		System.out.println(userInfo.getUserId());

		
	}
	
	@Test
	public void deleteUser(){
		userDao.deleteUser(8);
	}
	
	@Test
	public void updateUser(){
		userDao.updateUser(new UserInfo(6,"蔡小宝","123"));
	}
	
	@Test
	public void fuzzyQuery(){
		List<UserInfo> userInfos = userDao.fuzzyQuery("%小%");
		
		for (UserInfo userInfo : userInfos) {
			System.out.println(userInfo.getUserName()+"\t"+userInfo.getUserPass());
		}
	}
	
	@Test
	public void queryTotal(){
		int total = userDao.queryTotal();
		System.out.println(total);
	}
	
	@Test
	public void queryVo(){
		QueryVo queryVo = new QueryVo();
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(1);
		queryVo.setUserInfo(userInfo);
		
		
		String user_name = userDao.queryVo(queryVo);
		
		System.out.println(user_name);
	}
	
	@Test
	public void inquireSQL(){
		List<Integer> number = new ArrayList<Integer>();
		number.add(1);
		number.add(2);
		number.add(7);
		
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setNumber(number);
		
		List<UserInfo> userInfos = userDao.inquireSQL(userInfo1);
		
		for (UserInfo userInfo : userInfos) {
			System.out.println(userInfo.getUserId()+"\t"+userInfo.getUserName()+"\t"+userInfo.getUserPass());
		}
	}
}
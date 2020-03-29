package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ssm.bean.HouseInfo;
import com.ssm.bean.UserInfo;
import com.ssm.dao.inter.IHouseDao;

public class Test01 {

	InputStream in;
	SqlSession sqlSession;	
	IHouseDao houseDao;
	
	@Before
	public void init(){
		try {
			in =Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionFactory  sessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		sqlSession = sessionFactory.openSession();
		
		houseDao = sqlSession.getMapper(IHouseDao.class);
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
	public void testSelect(){
		HouseInfo houseInfo1 = new HouseInfo();
		houseInfo1.setHouse_title("1");
		
		
	}
	
	
	
}

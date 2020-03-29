package com.ssm.dao.inter;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ssm.bean.AdvancedQueryCondition;
import com.ssm.bean.HouseInfo;
import com.ssm.bean.UserInfo;
import com.ssm.sql.HouseDynamicSqlProvider;

@Repository
public interface IHouseDao{
	
	/**
	 * 查询当前用户
	 * @param 用户ID
	 * @return
	 */
	@Results(id="userMap",value={
		@Result(id=true,column="user_id",property="userId"),
		@Result(column="user_name",property="userName"),
		@Result(column="user_pass",property="userPass")
	})
	@Select("select * from user_info where user_id = #{user_id}")
	public UserInfo queryCurrentUser(int user_id);
	
	/**
	 * 查询所有房源信息
	 * @return
	 */
	public List<HouseInfo> queryAllHouseInfo();
	
	
	/**
	 * 模糊查询
	 * @param 房源标题
	 * @return
	 */
	@ResultMap("houseMap")
	@Select("SELECT * FROM house_info WHERE house_title LIKE #{house_title}")
	public List<HouseInfo> ditQuery(String house_title);
	
	
	
	
	/**
	 * 获取房源详细
	 * @param 房源id
	 * @return
	 */
	@ResultMap("houseMap")
	@Select("SELECT * FROM house_info WHERE house_id = #{house_id}")
	public HouseInfo houseDetail(int house_id);
	
	
	/**
	 * 新增房源
	 * @param houseInfo
	 */
	@Insert("insert into house_info VALUES(0, #{house_title}, #{house_district}, #{house_street}, #{rental_price}, "
			+ "#{room}, #{hall}, #{house_type}, #{contacts_phone}, #{contacts_name}, #{house_description}, #{user_id}, "
			+ "#{release_time})")
	public void addHouse(HouseInfo houseInfo); 
	
	
	/**
	 * 查询我的房源
	 * @param user_id
	 * @return
	 */
	@ResultMap("houseMap")
	@Select("select * from house_info where user_id = #{user_id}")
	public List<HouseInfo> queryMyHouse(int user_id);
	
	
	/**
	 * 删除房源
	 * @param 房源id
	 */
	@Delete("delete from house_info where house_id = #{house_id}")
	public void deleteHouse(int house_id);
	
	
	/**
	 * 修改房源
	 * @param 房源id
	 */
	@Update("UPDATE `house_system`.`house_info` SET  `house_title` = #{house_title} , `house_district` = #{house_district} , `house_street` = #{house_street} , `rental_price` = #{rental_price} , `room` = #{room} , `hall` = #{hall} , `house_type` = #{house_type} , `contacts_phone` = #{contacts_phone} , `contacts_name` = #{contacts_name}, `house_description` = #{house_description}  where `house_id` = #{house_id}")
	public void updateHouse(HouseInfo houseInfo);
	
	
	/**
	 * 分页查询
	 * @param 当前页面
	 * @param 每页的页码数
	 * @return
	 */
	@Results(id="houseMap",value={
		@Result(id=true,column="house_id",property="house_id"),
		@Result(column="house_title",property="house_title"),
		@Result(column="house_district",property="house_district"),
		@Result(column="house_street",property="house_street"),
		@Result(column="rental_price",property="rental_price"),
		@Result(column="hall",property="hall"),
		@Result(column="house_type",property="house_type"),
		@Result(column="contacts_phone",property="contacts_phone"),
		@Result(column="contacts_name",property="contacts_name"),
		@Result(column="house_description",property="house_description"),
		@Result(column="user_id",property="user_id"),
		@Result(column="release_time",property="release_time")
		}
	)
	@Select("SELECT * FROM house_info LIMIT #{currPage},3")
	public List<HouseInfo> pagingQuery(int currPage);
	
	
	/**
	 * 查询最大页面
	 * @return
	 */
	@Select("select count(*) from house_info")
	public int queryMaxPage();
	
	
	/**
	 * https://blog.csdn.net/trecn001/article/details/88038670
	 * 高级查询
	 * @param sql
	 * @return
	 */
	@ResultMap("houseMap")
	@SelectProvider(type=HouseDynamicSqlProvider.class,method="select")
	public List<HouseInfo> advancedQuery(AdvancedQueryCondition condition);
}

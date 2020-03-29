package com.ssm.service.inter;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Insert;

import com.ssm.bean.AdvancedQueryCondition;
import com.ssm.bean.HouseInfo;
import com.ssm.bean.UserInfo;

public interface IHouseService {
	
	
	
	/**
	 * 查询当前用户
	 * @param 用户ID
	 * @return
	 */
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
	public List<HouseInfo> ditQuery(String house_title);
	
	
	/**
	 * 获取房源详细
	 * @param 房源id
	 * @return
	 */
	public HouseInfo houseDetail(int house_id);
	
	
	/**
	 * 新增房源
	 * @param houseInfo
	 */
	public void addHouse(HouseInfo houseInfo); 
	
	
	/**
	 * 查询我的房源
	 * @param user_id
	 * @return
	 */
	public List<HouseInfo> queryMyHouse(int user_id);
	
	
	/**
	 * 删除房源
	 * @param 房源id
	 */
	public void deleteHouse(int house_id);
	
	
	/**
	 * 修改房源
	 * @param 房源id
	 */
	public void updateHouse(HouseInfo houseInfo);
	
	
	/**
	 * 分页查询
	 * @param 当前页面
	 * @param 每页的页码数
	 * @return
	 */
	public List<HouseInfo> pagingQuery(int currPage);
	
	
	/**
	 * 查询最大页面
	 * @return
	 */
	public int queryMaxPage();
	
	
	public List<HouseInfo> advancedQuery(AdvancedQueryCondition condition);
}

package com.ssm.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.bean.AdvancedQueryCondition;
import com.ssm.bean.HouseInfo;
import com.ssm.bean.UserInfo;
import com.ssm.dao.inter.IHouseDao;
import com.ssm.service.inter.IHouseService;

@Service
public class HouseService implements IHouseService{
	
	@Autowired
	private IHouseDao houseDao;
	
	@Override
	public UserInfo queryCurrentUser(int user_id) {
		// TODO Auto-generated method stub
		return houseDao.queryCurrentUser(user_id);
	}

	@Override
	public List<HouseInfo> queryAllHouseInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HouseInfo> ditQuery(String house_title) {
		// TODO Auto-generated method stub
		return houseDao.ditQuery(house_title);
	}


	public HouseInfo houseDetail(int house_id) {
		HouseInfo houseInfo = houseDao.houseDetail(house_id);
		
		houseInfo.println();
		
		return houseInfo;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addHouse(HouseInfo houseInfo) {
		houseDao.addHouse(houseInfo);
		
	}

	@Override
	public List<HouseInfo> queryMyHouse(int user_id) {
		// TODO Auto-generated method stub
		return houseDao.queryMyHouse(user_id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteHouse(int house_id) {
		houseDao.deleteHouse(house_id);
		
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateHouse(HouseInfo houseInfo) {
		houseDao.updateHouse(houseInfo);
		
	}

	@Override
	public List<HouseInfo> pagingQuery(int currPage){
	
		return houseDao.pagingQuery(currPage);
	}

	@Override
	public int queryMaxPage() {
		// TODO Auto-generated method stub
		return this.houseDao.queryMaxPage();
	}

	@Override
	public List<HouseInfo> advancedQuery(AdvancedQueryCondition condition) {
		
		if(condition.getHouse_types()!=null){
			List<Integer> types = condition.getHouse_types();
			
			for(int i=0;i<types.size();i++){
				if(types.get(i)==null){
					types.remove(i);
				}
			}
			
			condition.setHouse_types(types);
			
		}
		
		return houseDao.advancedQuery(condition);
	}

}

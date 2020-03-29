package com.ssm.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssm.bean.AdvancedQueryCondition;
import com.ssm.bean.HouseInfo;
import com.ssm.bean.UserInfo;
import com.ssm.service.impl.HouseService;

@Controller
@RequestMapping("/house")
@SessionAttributes(value={"MAX_PAGE","PAGING_DATA","CURRPAGE","USER_INFO","CURRENT_USER_ID","HOUSE_DETAIL","MY_HOUSE","UPDATE_HOUSE"})
public class HouseController{
	
	@Autowired
	private HouseService houseService;
	
	
	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("/pagingQuery.action")
	public String pagingQuery(Model model,int currPage,ModelMap modelMap){
			
		//每一页的条目数
		int countPage = 3;
		
		//最大页码数
		int maxPage = this.houseService.queryMaxPage();
			
		if(maxPage % countPage != 0){
			maxPage =(maxPage / countPage)+1;
		}else{
			maxPage = maxPage / countPage;
		}
		
		List<HouseInfo> houseInfos = this.houseService.pagingQuery((currPage-1)*countPage);
		
		model.addAttribute("MAX_PAGE", maxPage);
		
		model.addAttribute("PAGING_DATA", houseInfos);
		
		model.addAttribute("CURRPAGE", currPage);
		
		//获取当前用户id
		int user_id = (int)modelMap.get("CURRENT_USER_ID");
		
		UserInfo userInfo = this.houseService.queryCurrentUser(user_id);
		
		model.addAttribute("USER_INFO", userInfo);
		
		
		return "redirect:../pages/login.jsp";
	}
	
	
	/**
	 * 模糊查询
	 * @return
	 */
	@RequestMapping("/dimQuery.action")
	public String dimQuery(Model model,String house_title){
		
		List<HouseInfo> houseInfos = this.houseService.ditQuery("%"+house_title+"%");
		
		model.addAttribute("PAGING_DATA", houseInfos);
		
		return "redirect:../pages/login.jsp";
	}
	
	/**
	 * 删除房源
	 * @return
	 */
	@RequestMapping("/deleteHouse.action")
	public String deleteHouse(int houseId){
		
		this.houseService.deleteHouse(houseId);
		
		return "redirect:queryMyHouse.action";
	}
	
	
	/**
	 * 新增房源信息
	 * @return
	 */
	@RequestMapping(path="/addHouse.action",method=RequestMethod.POST)
	public String addHouse(HouseInfo houseInfo,ModelMap modelMap,Model model){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		houseInfo.setRelease_time(df.format(new Date()));
		
		//获取当前用户id
		int user_id = (int)modelMap.get("CURRENT_USER_ID");
		houseInfo.setUser_id(user_id);
		
		model.addAttribute("HOUSE_DETAIL", houseInfo);
		
		return "redirect:../pages/post_confirm.jsp";
	}
	
	
	/**
	 * 修改房源
	 * @return
	 */
	@RequestMapping("/updateHouse.action")
	public String updateHouse(Model model,HouseInfo house, int submit,int houseId){
		
		if(submit==0){
			
			HouseInfo houseInfo = this.houseService.houseDetail(houseId);
			
			model.addAttribute("UPDATE_HOUSE", houseInfo);
			
			return "redirect:../pages/update.jsp";
		}else{
			
			this.houseService.updateHouse(house);
		
			return "redirect:queryMyHouse.action";
		}
		
		
	}
	
	/**
	 * 查询我的房源信息
	 * @return
	 */
	@RequestMapping("queryMyHouse.action")
	public String queryMyHouse(ModelMap modelMap,Model model){
		
		//获取当前用户id
		int user_id = (int)modelMap.get("CURRENT_USER_ID");
		
		System.out.println(user_id);
		
		List<HouseInfo> houseInfos = this.houseService.queryMyHouse(user_id);
		
		model.addAttribute("MY_HOUSE", houseInfos);
		
		for (HouseInfo houseInfo : houseInfos) {
			houseInfo.println();
		}
		
		
		return "redirect:../pages/my.jsp";
	}	
	
	/**
	 * 查询房源详细信息
	 * @return
	 */
	@RequestMapping("/houseDetail.action")
	public String queryHouseDetailInfo(Model model,int houseId){
		
		
		
		HouseInfo houseInfo = this.houseService.houseDetail(houseId);
		
		System.out.println(houseId+"---------");
		
		houseInfo.println();
		
		model.addAttribute("HOUSE_DETAIL", houseInfo);
		
		return "redirect:../pages/detail.jsp";
	} 
	
	
	/**
	 * 高级查询
	 * @return
	 */
	@RequestMapping(path="/advancedQuery.action",method=RequestMethod.POST)
	public String advancedQuery(Model model,AdvancedQueryCondition condition){
		
		List<HouseInfo> houseInfos = this.houseService.advancedQuery(condition);		
		
		model.addAttribute("PAGING_DATA", houseInfos);
		
		return "redirect:../pages/login.jsp";
	}
	
	
	/**
	 * 提交房源信息
	 * @return
	 */
	@RequestMapping("/confirmSubmitHouse.action")
	public String confirmSubmitHouse(ModelMap modelMap){
		
		HouseInfo houseInfo = (HouseInfo)modelMap.get("HOUSE_DETAIL");
		
		this.houseService.addHouse(houseInfo);
		
		return "redirect:pagingQuery.action?currPage=1";
	}
	
}

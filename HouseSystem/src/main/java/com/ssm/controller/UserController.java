package com.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ssm.bean.UserInfo;
import com.ssm.service.impl.UserService;

@RequestMapping("/user")
@Controller
@SessionAttributes(value={"CURRENT_USER_ID"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("/userRegister.action")
	public String userRegister(UserInfo user){
		
		userService.saveUser(user);
		
		return "redirect:../pages/index.jsp";
	}
	
	/**
	 * 用户登入
	 * @return
	 */
	@RequestMapping("/userLogin.action")
	public ResponseEntity<Map<String, Integer>> userLogin(UserInfo user,Model model){
		
		System.out.println("用户登入..."+user.getUserName()+"\t"+user.getUserPass());
		
		int user_id = this.userService.loginSystem(user);
		
		Map<String, Integer> map = new HashMap<>();
		
		if(user_id>0){
			//校验正确后，将当前用户Id保存到session作用域
			model.addAttribute("CURRENT_USER_ID", user_id);
			
			map.put("result", 1);
		}else{
			map.put("result", 0);
		}
		
		return ResponseEntity.ok(map);
	}
	
	
	/**
	 * 注销当前用户
	 * @return
	 */
	@RequestMapping("writeroff.action")
	public String writerOff_User(SessionStatus status){
		
		//清除所有的session作用域
		status.isComplete();
		
		return "redirect:../pages/index.jsp";
	}
}

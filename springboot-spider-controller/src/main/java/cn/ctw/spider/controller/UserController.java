package cn.ctw.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ctw.spider.entity.User;
import cn.ctw.spider.info.UserException;
import cn.ctw.spider.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	/**
	 * 注册成功跳转到登录页面
	 * @param user
	 * @throws UserException 
	 * 
	 */
	@RequestMapping("/registered")
	public String registered(User user) throws UserException{
		
		userService.registered(user);
		return "login";
	}
	
	/**
	 * 登录成功跳转到首页
	 * @param user
	 * @return
	 * @throws UserException 
	 */
	@RequestMapping("/login")
	public String login(User user,Model model) throws UserException{
		
		User Exituser = userService.login(user);
		// 将查询的user传给页面
		model.addAttribute(Exituser);
		return "index";
	}
	
}

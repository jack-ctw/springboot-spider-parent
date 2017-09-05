package cn.ctw.spider.controller;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ctw.spider.SpiderApplication;
import cn.ctw.spider.entity.User;
import cn.ctw.spider.info.UserException;
import cn.ctw.spider.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpiderApplication.class)
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	

	@Test
	public void registeredTest(){
		
		try {
			User user = new User();
			//user.setId(1033L);
			user.setUserCode("test3");
			user.setPassWord("test3");
			userService.registered(user);
		} catch (UserException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest() throws UserException{
		User user = new User();
		user.setUserCode("test");
		user.setPassWord("test");
		User user2 = userService.login(user);
		System.out.println(user2.getUserCode());
	}
	
	@Test
	public void springCacheTest() throws UserException{
		User user = new User();
		user.setUserCode("test");
		user.setPassWord("test");
		System.out.println("第一次登陆");
		userService.login(user);
		System.out.println("第二次登陆");
		userService.login(user);
		
	}
	
	
}

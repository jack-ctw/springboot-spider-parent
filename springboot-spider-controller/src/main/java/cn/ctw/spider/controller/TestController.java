package cn.ctw.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ctw.spider.service.SpiderService;


@Controller
public class TestController {

	@Autowired
	private SpiderService spiderService;
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello(String test1){
		String test = spiderService.testMybatis(test1);
		return test;
	}
	
	@GetMapping("/jpa")
	@ResponseBody
	public String testJpa(){
		String test = spiderService.testJpa();
		return test;
	}
}

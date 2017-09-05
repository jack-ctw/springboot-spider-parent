package cn.ctw.spider.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ctw.spider.SpiderApplication;
import cn.ctw.spider.service.SpiderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpiderApplication.class)
public class SpiderControllerTest {
	
	@Autowired
	private SpiderService spiderService;
	
	@Test
	public void testJpaTest(){
		String jpa = spiderService.testJpa();
		System.out.println(jpa);
	}
	
	
	@Test
	public void testMybatisTest(){
		String test = "test";
		String mybatis = spiderService.testMybatis(test);
		System.out.println(mybatis);
	}
}

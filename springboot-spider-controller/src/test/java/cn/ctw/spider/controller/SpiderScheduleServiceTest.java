package cn.ctw.spider.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ctw.spider.SpiderApplication;
import cn.ctw.spider.service.SpiderScheduleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpiderApplication.class)
public class SpiderScheduleServiceTest {

	@Autowired
	private SpiderScheduleService scheduleService;
	
	/**
	 *	测试添加avgScore的调度任务 
	 */
	@Test
	public void saveRankMovieDetailsTest(){
		
		scheduleService.saveRankMovieDetails();
	}
	
	@Test
	public void saveHistoryBoxOfficeTest(){
		
		scheduleService.saveHistoryBoxOffice();
	}

}

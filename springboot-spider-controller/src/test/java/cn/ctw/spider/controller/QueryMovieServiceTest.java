package cn.ctw.spider.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ctw.spider.SpiderApplication;
import cn.ctw.spider.service.QueryMovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpiderApplication.class)
public class QueryMovieServiceTest {
	
	@Autowired
	private QueryMovieService queryMovieService;
	
	@Test
	public void queryMovieDetailsByMidTest(){
		queryMovieService.queryMovieDetailsByMid("641515");
	}
	
	@Test
	public void everyDayBoxOfficeList(){
		queryMovieService.everyDayBoxOfficeList("641515");
	}
	
	@Test
	public void realtimeRank(){
		queryMovieService.realtimeRank();
	}
	
}

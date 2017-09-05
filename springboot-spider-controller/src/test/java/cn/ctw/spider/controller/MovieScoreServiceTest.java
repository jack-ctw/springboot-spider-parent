package cn.ctw.spider.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ctw.spider.SpiderApplication;
import cn.ctw.spider.entity.MovieDetails;
import cn.ctw.spider.entity.MovieScore;
import cn.ctw.spider.info.UserException;
import cn.ctw.spider.service.MovieScoreService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpiderApplication.class)
public class MovieScoreServiceTest {

	@Autowired
	private MovieScoreService movieScoreService;
	
	/**
	 * 测试评分
	 * @throws UserException 
	 */
	@Test
	public void insertMovieScoreTest() throws UserException{
		
		MovieScore movieScore = new MovieScore();
		movieScore.setId((long) 1);
		movieScore.setMid("666143");
		movieScore.setScore(80);
		movieScore.setUserCode("test");
		movieScoreService.insertMovieScore(movieScore);
	}
	
	/**
	 * 测试统计平均分
	 */
	@Test
	public void getAvgScoreTest(){
		
		String avgScore = movieScoreService.getAvgScore("641515");
		System.out.println(avgScore);
	}
	
	@Test
	public void selectMovieDetailsByUserCodeTest() throws UserException{
		
		List<MovieDetails> movieDetailsList = movieScoreService.selectMovieDetailsByUserCode("test");
		System.out.println(movieDetailsList.size());
	}

}

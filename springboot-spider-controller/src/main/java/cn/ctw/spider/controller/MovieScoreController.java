package cn.ctw.spider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alibaba.fastjson.JSON;

import cn.ctw.spider.entity.MovieDetails;
import cn.ctw.spider.entity.MovieScore;
import cn.ctw.spider.info.UserException;
import cn.ctw.spider.service.MovieScoreService;

@Controller
public class MovieScoreController {
	
	@Autowired
	private MovieScoreService movieScoreService;

	/**
	 * 用户评分
	 * @param movieScore
	 * @return
	 * @throws UserException 
	 */
	@PostMapping("/insertMovieScore_restful")
	public ResponseEntity<Void> insertMovieScore_restful(MovieScore movieScore){
		
		try {
			
			movieScoreService.insertMovieScore(movieScore);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (UserException e) {
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	
	/**
	 * 查询自己评分的电影
	 * @param userCode
	 * @return
	 * @throws UserException 
	 */
	@GetMapping("/selectMovieDetailsByUserCode_restful/{userCode}")
	public ResponseEntity<String> selectMovieDetailsByUserCode_restful(@PathVariable("userCode") String userCode){
		
		try {
			List<MovieDetails> movieDetailsList = movieScoreService.selectMovieDetailsByUserCode(userCode);
			if(movieDetailsList!=null){
				return ResponseEntity.ok(JSON.toJSONString(movieDetailsList));
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (UserException e) {
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
}

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

import cn.ctw.spider.entity.MovieComment;
import cn.ctw.spider.entity.MovieDetails;
import cn.ctw.spider.info.UserException;
import cn.ctw.spider.service.MovieCommentService;



@Controller
public class MovieCommentController {

	@Autowired
	private MovieCommentService movieCommentService;

	
	
	/**
	 * 新增评论
	 * @param movieComment
	 * @return
	 * 
	 */
	@PostMapping("/insertMovieComment_restful")
	public ResponseEntity<Void> insertMovieComment_restful(MovieComment movieComment){
		
		try {
			movieCommentService.insertMovieComment(movieComment);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	/**
	 * 查询该电影所有的评论
	 * @param mid
	 * @return
	 * @throws UserException 
	 */
	@GetMapping("/QueryCommentsByMid_restful/{mid}")
	public ResponseEntity<String> QueryCommentsByMid_restful(String mid){
		
		try {
			List<MovieComment> moviecommentsList = movieCommentService.QueryCommentsByMid(mid);
			if (moviecommentsList != null) {
				return ResponseEntity.ok(JSON.toJSONString(moviecommentsList));
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (UserException e) {
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	
	/**
	 * 查询用户评论的电影
	 * @param userCode
	 * @return
	 * @throws UserException 
	 */
	@GetMapping("/queryMovieDetailsByUserCode_restful/{userCode}")
	public ResponseEntity<String> queryMovieDetailsByUserCode_restful(@PathVariable("userCode") String userCode){
		try {
			List<MovieDetails> movieDetailsList = movieCommentService.queryMovieDetailsByUserCode(userCode);
			if(movieDetailsList!=null){
				return ResponseEntity.ok(JSON.toJSONString(movieDetailsList));
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (UserException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
}

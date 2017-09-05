package cn.ctw.spider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ctw.spider.dao.jpa.MovieCommentDao;
import cn.ctw.spider.dao.mapper.MovieCommentMapper;
import cn.ctw.spider.dao.mapper.MovieDetailsMapper;
import cn.ctw.spider.entity.MovieComment;
import cn.ctw.spider.entity.MovieDetails;
import cn.ctw.spider.info.UserException;



/**
 * 电影评论模块
 * 
 * @author jack
 *
 */
@Service
public class MovieCommentService {

	@Autowired
	private MovieCommentDao moiveCommentDao;
	@Autowired
	private MovieCommentMapper movieCommentMapper;
	@Autowired
	private MovieDetailsMapper movieDetailsMapper;
	/*
	 * @Autowired private JedisPool jedisPool
	 */;

	/**
	 * 增加评论
	 * 
	 */
	@Transactional
	@CacheEvict(value={"queryMovieDetailsByUserCode","QueryCommentsByMid"},allEntries = true)
	public void insertMovieComment(MovieComment movieComment) {

		moiveCommentDao.save(movieComment);
	}

	/**
	 * 用户查询自己评论过的电影
	 * 
	 * @throws UserException
	 */
	@Cacheable("queryMovieDetailsByUserCode")
	public List<MovieDetails> queryMovieDetailsByUserCode(String userCode) throws UserException {

		if (userCode != null) {

			// 查询
			List<MovieDetails> movieDetailsList = new ArrayList<>();
			List<MovieComment> MoveCommentList = movieCommentMapper.queryMovieCommentByUserCode(userCode);
			for (MovieComment movieComment : MoveCommentList) {
				String mid = movieComment.getMid();
				MovieDetails movieDetails = movieDetailsMapper.queryMovieDetailsByMid(mid).get(0);
				movieDetailsList.add(movieDetails);

			}
			return movieDetailsList;
		} else {
			throw new UserException("登陆异常");
		}

	}

	/**
	 * 查询该电影的所有评论
	 * 
	 * @throws UserException
	 */
	@Cacheable("QueryCommentsByMid")
	public List<MovieComment> QueryCommentsByMid(String mid) throws UserException {

		if (mid != null) {

			List<MovieComment> MovieCommentList = movieCommentMapper.queryMovieCommentByMid(mid);
			return MovieCommentList;
		} else {
			throw new UserException("没有此电影");
		}
	}

}

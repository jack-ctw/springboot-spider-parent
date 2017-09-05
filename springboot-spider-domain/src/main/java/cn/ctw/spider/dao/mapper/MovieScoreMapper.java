package cn.ctw.spider.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ctw.spider.entity.MovieScore;

@Mapper
public interface MovieScoreMapper{
	/**
	 * 唯一性查询 
	 */
	List<MovieScore> queryMovieScoreByMidAndUserCore(String mid,String UserCode);
	
	/**
	 * 查看该用户所有的电影评分
	 */
	List<MovieScore> queryMovieScoreByUserCode(String userCode);
	
	/**
	 * 查看该电影所有评分
	 */
	List<MovieScore> queryMovieScoreByMid(String Mid);
}

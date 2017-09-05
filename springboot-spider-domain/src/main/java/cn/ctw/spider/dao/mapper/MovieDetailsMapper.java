package cn.ctw.spider.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ctw.spider.entity.MovieDetails;

@Mapper
public interface MovieDetailsMapper  {
	/**
	 * 根据mid查询电影
	 */
	List<MovieDetails> queryMovieDetailsByMid(String mid);

}

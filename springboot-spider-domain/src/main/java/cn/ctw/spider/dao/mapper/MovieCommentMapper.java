package cn.ctw.spider.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.ctw.spider.entity.MovieComment;

@Mapper
public interface MovieCommentMapper extends JpaRepository<MovieComment, String>{
	/**
	 * 	查询用户评论的所有评论
	 */
	List<MovieComment> queryMovieCommentByUserCode(String userCode);
	
	/**
	 *	根据mid 和 userCode 查询
	 */
	List<MovieComment> queryMovieCommentByMid(String mid);
}

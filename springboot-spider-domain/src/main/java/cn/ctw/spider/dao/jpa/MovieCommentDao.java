package cn.ctw.spider.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.ctw.spider.entity.MovieComment;

@Repository
public interface MovieCommentDao extends JpaRepository<MovieComment, String>{
	/**
	 * 	查询用户评论的所有评论
	 */
	List<MovieComment> findByUserCode(String userCode);
	
	/**
	 *	根据mid 和 userCode 查询
	 */
	List<MovieComment> findByMid(String mid);
}

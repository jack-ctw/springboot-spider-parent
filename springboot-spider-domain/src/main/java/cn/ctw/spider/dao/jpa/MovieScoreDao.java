package cn.ctw.spider.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.ctw.spider.entity.MovieScore;

@Repository
public interface MovieScoreDao extends JpaRepository<MovieScore, String>{
	/**
	 * 唯一性查询 
	 */
	List<MovieScore> findByMidAndUserCode(String mid,String UserCode);
	
	/**
	 * 查看该用户所有的电影评分
	 */
	List<MovieScore> findByUserCode(String userCode);
	
	/**
	 * 查看该电影所有评分
	 */
	List<MovieScore> findByMid(String Mid);
}

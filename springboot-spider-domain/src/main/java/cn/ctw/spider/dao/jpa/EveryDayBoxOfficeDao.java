package cn.ctw.spider.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.ctw.spider.entity.EveryDayBoxOffice;

@Repository
public interface EveryDayBoxOfficeDao extends JpaRepository<EveryDayBoxOffice, String>{
	/*
	 * 根据mid查询电影
	 */
	List<EveryDayBoxOffice> findByMid(String mid);
	
}

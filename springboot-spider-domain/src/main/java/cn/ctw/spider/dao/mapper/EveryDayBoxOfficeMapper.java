package cn.ctw.spider.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.ctw.spider.entity.EveryDayBoxOffice;

@Mapper
public interface EveryDayBoxOfficeMapper extends JpaRepository<EveryDayBoxOffice, String>{
	/*
	 * 根据mid查询电影
	 */
	List<EveryDayBoxOffice> queryEveryDayBoxOfficByMid(String mid);
	
}

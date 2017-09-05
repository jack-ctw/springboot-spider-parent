package cn.ctw.spider.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.ctw.spider.dao.mapper.EveryDayBoxOfficeMapper;
import cn.ctw.spider.dao.mapper.MovieDetailsMapper;
import cn.ctw.spider.dto.RealtimeRank;
import cn.ctw.spider.entity.EveryDayBoxOffice;
import cn.ctw.spider.entity.MovieDetails;

@Service
public class QueryMovieService {

	@Autowired
	private EveryDayBoxOfficeMapper everyDayBoxOfficeMapper;
	@Autowired
	private MovieDetailsMapper movieDetailsMapper;
	@Autowired
	private CboooSpiderService cboooSpiderService;

	/**
	 * 根据电影Id获取电影详细信息
	 * 
	 */
	@Cacheable("queryMovieDetailsByMid")
	public MovieDetails queryMovieDetailsByMid(String mid) {
		// 查询后放入缓存
		MovieDetails movieDetails = movieDetailsMapper.queryMovieDetailsByMid(mid).get(0);
		return movieDetails;
	}

	/**
	 * 根据电影Id获取电影每日票房信息
	 * 
	 */
	@Cacheable("everyDayBoxOfficeList")
	public List<EveryDayBoxOffice> everyDayBoxOfficeList(String mid) {

		List<EveryDayBoxOffice> everyDayBoxOfficeList = everyDayBoxOfficeMapper.queryEveryDayBoxOfficByMid(mid);
		return everyDayBoxOfficeList;
	}

	/**
	 * 查询排行榜电影信息
	 * 
	 */
	@Cacheable("realtimeRank")
	public RealtimeRank realtimeRank() {

		RealtimeRank realtimeRank = cboooSpiderService.realtimeRank();
		return realtimeRank;
	}

}

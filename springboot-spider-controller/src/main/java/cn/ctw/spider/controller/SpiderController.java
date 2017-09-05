package cn.ctw.spider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibaba.fastjson.JSON;

import cn.ctw.spider.dto.RealtimeRank;
import cn.ctw.spider.entity.EveryDayBoxOffice;
import cn.ctw.spider.entity.MovieDetails;
import cn.ctw.spider.service.QueryMovieService;

@Controller
public class SpiderController {

	@Autowired
	private QueryMovieService queryMovieSerivice;

	/**
	 * 更新版本的restful接口 http:127.0.0.1:8080/spider-web/movieDetails_restful/641515
	 * 
	 * @param mid
	 * @return
	 */
	@GetMapping("/movieDetails_restful/{mid}")
	public ResponseEntity<MovieDetails> movieDetails_restful(@PathVariable(value = "mid") String mid) {

		try {
			if (mid != null) {
				MovieDetails movieDetails = queryMovieSerivice.queryMovieDetailsByMid(mid);
				return ResponseEntity.ok(movieDetails);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (Exception e) {
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	/**
	 * 根据电影Id获取电影每日票房信息
	 * url:http:127.0.0.1:8080/spider-web/everyDayBoxOfficeList_restful/641515
	 * 
	 * @param mid
	 * @return List<EveryDayBoxOffice>
	 */

	@GetMapping("/everyDayBoxOfficeList_restful/{mid}")
	public ResponseEntity<String> everyDayBoxOfficeList_restful(
			@PathVariable(value = "mid") String mid) {
		try {
			if (mid != null) {
				List<EveryDayBoxOffice> everyDayBoxOfficeList = queryMovieSerivice.everyDayBoxOfficeList(mid);
				return ResponseEntity.ok(JSON.toJSONString(everyDayBoxOfficeList));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (Exception e) {
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	/**
	 * 查询实时排行榜票房信息
	 * http:127.0.0.1:8080/spider-web/realtimeRank_restful
	 * @return RealtimeRank
	 * 
	 */
	@GetMapping("/realtimeRank_restful")
	public ResponseEntity<RealtimeRank> realtimeRank_restful() {
		try {

			RealtimeRank realtimeRank = queryMovieSerivice.realtimeRank();
			return ResponseEntity.ok(realtimeRank);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

}

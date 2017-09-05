package cn.ctw.spider.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.ctw.spider.dto.HistoryBoxOffice;
import cn.ctw.spider.dto.RealtimeBoxOffice;
import cn.ctw.spider.dto.RealtimeRank;
import cn.ctw.spider.entity.MovieDetails;


/**
 * 爬虫模块
 * @author jack
 *
 */
@Service
public class CboooSpiderService {
	/**
	 * 获取实时票房排行榜
	 * 
	 * @return RealtimeRank
	 */
	public RealtimeRank realtimeRank() {

		RealtimeRank realtimRank = new RealtimeRank();
		List<RealtimeBoxOffice> rbflist = new ArrayList<RealtimeBoxOffice>();
		try {
			Document doc = Jsoup.connect("http://m.cbooo.cn/").data("query", "Java").userAgent("Mozilla")
					.cookie("auth", "token").timeout(3000).get();
			// 总票房数
			String allrealtimeBoxOffice = doc.select("h3").select("span").get(0).text();
			realtimRank.setRealtimeAmountBoxOffice(allrealtimeBoxOffice);

			// 封装实时排行榜数据
			Elements elements = doc.getElementsByClass("js_bg").select("tbody").select("tr");
			for (int i = 0; i < elements.size(); i++) {
				
				RealtimeBoxOffice rbo = new RealtimeBoxOffice();
				String[] split = elements.get(i).text().split(" ");
				String name = split[0];
				String amountBoxOffice = split[1];
				String releasedDays = split[2];
				String realtimeBoxOffice = split[3];
				String boxOfficeRatio = split[4];
				String screeningRatio = split[5];
				String tomorrowScreenings = split[6];
				rbo.setName(name);
				rbo.setAmountBoxOffice(amountBoxOffice);
				rbo.setReleasedDays(releasedDays);
				rbo.setRealtimeBoxOffice(realtimeBoxOffice);
				rbo.setBoxOfficeRatio(boxOfficeRatio);
				rbo.setScreeningRatio(screeningRatio);
				rbo.setTomorrowScreenings(tomorrowScreenings);
				
				// 将排行榜的每部电影push到list中
				rbflist.add(rbo);
				realtimRank.setAllRealtimeBoxOffice(rbflist);
				
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return realtimRank;
	}

	/**
	 * 获取电影具体信息
	 * 
	 * @param movieId
	 * @return MovieDetails
	 */
	public MovieDetails movieDetails(String movieId) {

		MovieDetails movieDetails = new MovieDetails();

		try {
			Document doc = Jsoup.connect("http://m.cbooo.cn/Movie/MovieDetails?Mid=" + movieId).data("query", "Java")
					.userAgent("Mozilla").cookie("auth", "token").timeout(3000).post();
			// 电影基本信息
			Elements select = doc.getElementById("detail_head").select("p");
			String name = doc.getElementById("detail_head").select("h2").text();
			String type = select.get(0).select("span").get(1).text();
			String duration = select.get(1).select("span").get(1).text();
			String releaseTime = select.get(2).select("span").get(1).text();
			String releasedDays = select.get(3).select("span").get(1).text();
			String standard = select.get(4).select("span").get(1).text();
			String country = select.get(5).select("span").get(1).text();
			String company = select.get(6).select("span").get(1).text();
			// 封装电影基本信息
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(releaseTime);
			movieDetails.setName(name);
			movieDetails.setType(type);
			movieDetails.setDuration(duration);
			movieDetails.setReleaseTime(date);
			movieDetails.setReleasedDays(releasedDays);
			movieDetails.setStandard(standard);
			movieDetails.setCountry(country);
			movieDetails.setCompany(company);
			// 电影票房信息
			Elements select2 = doc.getElementById("detail_body").select("li");
			String realtimeBoxOffice = select2.get(0).select("p").get(1).text();
			String amountBoxOffice = select2.get(1).select("p").get(1).text();
			String experimentBoxOffice = select2.get(2).select("p").get(1).text();
			String firstDayBoxOffice = select2.get(3).select("p").get(1).text();
			String firstWeekBoxOffice = select2.get(4).select("p").get(1).text();
			String firstWeekendBoxOffice = select2.get(5).select("p").get(1).text();
			// 封装电影票房信息
			movieDetails.setRealtimeBoxOffice(realtimeBoxOffice);
			movieDetails.setAmountBoxOffice(amountBoxOffice);
			movieDetails.setExperimentBoxOffice(experimentBoxOffice);
			movieDetails.setFirstDayBoxOffice(firstDayBoxOffice);
			movieDetails.setFirstWeekBoxOffice(firstWeekBoxOffice);
			movieDetails.setFirstWeekendBoxOffice(firstWeekendBoxOffice);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movieDetails;
	}

	/**
	 * 获取历史每日票房数据
	 * 
	 * @param movieId
	 * @return HistoryBoxOffice
	 */
	public HistoryBoxOffice historyBoxOffice(String movieId) {
		try {
			// 获取数据
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://m.cbooo.cn/Movie/GetTrend?mId=" + movieId);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String datas = EntityUtils.toString(entity, "UTF-8");
			HistoryBoxOffice historyBoxOffice = JSON.parseObject(datas, HistoryBoxOffice.class);
			return historyBoxOffice;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 获取排行榜上的 mid集合
	 * @return List<String> midList
	 */
	public List<String> getMidList(){
		
		ArrayList<String> arrayList = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect("http://m.cbooo.cn/").data("query", "Java").userAgent("Mozilla")
					.cookie("auth", "token").timeout(3000).get();
			Element element = doc.getElementsByClass("js_bg").get(0).select("tbody").get(0);
			Pattern p = Pattern.compile("Mid=[^\r']+");
			Matcher matcher = p.matcher(element.html());
			while(matcher.find()){
				arrayList.add(matcher.group(0).substring(4));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arrayList;
	}
}

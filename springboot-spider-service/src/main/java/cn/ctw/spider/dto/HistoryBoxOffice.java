package cn.ctw.spider.dto;

import java.io.Serializable;
import java.util.List;

import cn.ctw.spider.entity.EveryDayBoxOffice;

/**
 * 单个电影历史每日的数据(所有)
 * @author jack
 *
 */
public class HistoryBoxOffice implements Serializable{
	//封装历史每日票房
	private List<EveryDayBoxOffice> data1;

	public List<EveryDayBoxOffice> getData1() {
		return data1;
	}

	public void setData1(List<EveryDayBoxOffice> data1) {
		this.data1 = data1;
	}
	

}

package cn.ctw.spider.dto;

import java.io.Serializable;

import javax.persistence.*;


/**
 * 每个电脑实时数据
 * @author jack
 *
 */

public class RealtimeBoxOffice implements Serializable{


    private long id ;
	//片名
	private String name;
	//总票房
	private String amountBoxOffice;
	//上映天数
	private String releasedDays;
	//实时票房
	private String realtimeBoxOffice;
	//票房占比
	private String boxOfficeRatio;
	//排片率
	private String screeningRatio;
	//明日理想片场
	private String tomorrowScreenings;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAmountBoxOffice() {
		return amountBoxOffice;
	}
	
	public void setAmountBoxOffice(String amountBoxOffice) {
		this.amountBoxOffice = amountBoxOffice;
	}
	
	public String getReleasedDays() {
		return releasedDays;
	}
	
	public void setReleasedDays(String releasedDays) {
		this.releasedDays = releasedDays;
	}
	
	public String getRealtimeBoxOffice() {
		return realtimeBoxOffice;
	}
	
	public void setRealtimeBoxOffice(String realtimeBoxOffice) {
		this.realtimeBoxOffice = realtimeBoxOffice;
	}
	
	public String getBoxOfficeRatio() {
		return boxOfficeRatio;
	}
	
	public void setBoxOfficeRatio(String boxOfficeRatio) {
		this.boxOfficeRatio = boxOfficeRatio;
	}
	
	public String getScreeningRatio() {
		return screeningRatio;
	}
	
	public void setScreeningRatio(String screeningRatio) {
		this.screeningRatio = screeningRatio;
	}
	
	public String getTomorrowScreenings() {
		return tomorrowScreenings;
	}
	
	public void setTomorrowScreenings(String tomorrowScreenings) {
		this.tomorrowScreenings = tomorrowScreenings;
		
	}


}

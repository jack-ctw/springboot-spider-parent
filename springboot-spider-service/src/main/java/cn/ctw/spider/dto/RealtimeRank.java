package cn.ctw.spider.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * 实时票房排行榜
 * @author jack
 *
 */

public class RealtimeRank implements Serializable{
	
	//实时总票房数
	private String realtimeAmountBoxOffice;
	//实时票房排行榜
	private List<RealtimeBoxOffice> allRealtimeBoxOffice;
	
	public List<RealtimeBoxOffice> getAllRealtimeBoxOffice() {
		return allRealtimeBoxOffice;
	}
	
	public void setAllRealtimeBoxOffice(List<RealtimeBoxOffice> allRealtimeBoxOffice) {
		this.allRealtimeBoxOffice = allRealtimeBoxOffice;
	}
	
	public String getRealtimeAmountBoxOffice() {
		return realtimeAmountBoxOffice;
	}
	
	public void setRealtimeAmountBoxOffice(String realtimeAmountBoxOffice) {
		this.realtimeAmountBoxOffice = realtimeAmountBoxOffice;
	
	}
	
}

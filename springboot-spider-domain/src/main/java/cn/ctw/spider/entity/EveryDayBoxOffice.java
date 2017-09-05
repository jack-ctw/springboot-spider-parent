package cn.ctw.spider.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 单个电影历史每日数据(1天)
 * 
 * @author jack
 *
 */
@Entity
@Table(name = "everyDayBoxOffice")
public class EveryDayBoxOffice implements Serializable {

	private static final long serialVersionUID = -6739328982375850612L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	// 电影id
	@Column(name="Mid")
	private String mid;
	// 日期
	@Column(name="InsertDate")
	private String InsertDate;
	// 星期几
	@Column(name="ReleaseDay")
	private String ReleaseDay;
	// 票房
	@Column(name="Boxoffice")
	private String Boxoffice;
	// 票房占比
	@Column(name="BoxPercent")
	private String BoxPercent;
	// 拍片占比
	@Column(name="ShowPercent")
	private String ShowPercent;

	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInsertDate() {
		return InsertDate;
	}

	public void setInsertDate(String insertDate) {
		InsertDate = insertDate;
	}

	public String getReleaseDay() {
		return ReleaseDay;
	}

	public void setReleaseDay(String releaseDay) {
		ReleaseDay = releaseDay;
	}

	public String getBoxoffice() {
		return Boxoffice;
	}

	public void setBoxoffice(String boxoffice) {
		Boxoffice = boxoffice;
	}

	public String getBoxPercent() {
		return BoxPercent;
	}

	public void setBoxPercent(String boxPercent) {
		BoxPercent = boxPercent;
	}

	public String getShowPercent() {
		return ShowPercent;
	}

	// 为了生成表 暂时修改此方法
	public EveryDayBoxOffice setShowPercent(String showPercent) {
		ShowPercent = showPercent;
		return this;
	}

}

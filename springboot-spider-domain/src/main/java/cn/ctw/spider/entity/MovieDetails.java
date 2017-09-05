package cn.ctw.spider.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Moviedetails")
public class MovieDetails implements Serializable {
	
	private static final long serialVersionUID = -4554712501707355294L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="MID")
	private String mid;
	// 片名
	@Column(name="NAME")
	private String name;
	// 类型
	@Column(name="TYPE")
	private String type;
	// 片长
	@Column(name="DURATION")
	private String duration;
	// 上映时间
	@Column(name="RELEASETIME")
	private Date releaseTime;
	// 上映天数
	@Column(name="RELEASEDDAYS")
	private String releasedDays;
	// 制式
	@Column(name="STANDARD")
	private String standard;
	// 国家地区
	@Column(name="COUNTRY")
	private String country;
	// 发行公司
	@Column(name="COMPANY")
	private String company;
	// 今天实时票房
	@Column(name="REALTIMEBOXOFFICE")
	private String realtimeBoxOffice;
	// 累计票房
	@Column(name="AMOUNTBOXOFFICE")
	private String amountBoxOffice;
	// 点映票房
	@Column(name="EXPERIMENTBOXOFFICE")
	private String experimentBoxOffice;
	// 首映票房
	@Column(name="FIRSTDAYBOXOFFICE")
	private String firstDayBoxOffice;
	// 首周票房
	@Column(name="FIRSTWEEKBOXOFFICE")
	private String firstWeekBoxOffice;
	// 首周末票房
	@Column(name="FIRSTWEEKENDBOXOFFICE")
	private String firstWeekendBoxOffice;
	// 平均分
	@Column(name="AVGSCORE")
	private String avgScore;
	
	public String getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getReleasedDays() {
		return releasedDays;
	}

	public void setReleasedDays(String releasedDays) {
		this.releasedDays = releasedDays;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRealtimeBoxOffice() {
		return realtimeBoxOffice;
	}

	public void setRealtimeBoxOffice(String realtimeBoxOffice) {
		this.realtimeBoxOffice = realtimeBoxOffice;
	}

	public String getAmountBoxOffice() {
		return amountBoxOffice;
	}

	public void setAmountBoxOffice(String amountBoxOffice) {
		this.amountBoxOffice = amountBoxOffice;
	}

	public String getExperimentBoxOffice() {
		return experimentBoxOffice;
	}

	public void setExperimentBoxOffice(String experimentBoxOffice) {
		this.experimentBoxOffice = experimentBoxOffice;
	}

	public String getFirstDayBoxOffice() {
		return firstDayBoxOffice;
	}

	public void setFirstDayBoxOffice(String firstDayBoxOffice) {
		this.firstDayBoxOffice = firstDayBoxOffice;
	}

	public String getFirstWeekBoxOffice() {
		return firstWeekBoxOffice;
	}

	public void setFirstWeekBoxOffice(String firstWeekBoxOffice) {
		this.firstWeekBoxOffice = firstWeekBoxOffice;
	}

	public String getFirstWeekendBoxOffice() {
		return firstWeekendBoxOffice;
	}

	// 为了生成表 暂时修改此方法
	public MovieDetails setFirstWeekendBoxOffice(String firstWeekendBoxOffice) {
		this.firstWeekendBoxOffice = firstWeekendBoxOffice;
		return this;
	}

}

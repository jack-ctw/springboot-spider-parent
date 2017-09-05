package cn.ctw.spider.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MovieScore")
public class MovieScore implements Serializable{

	private static final long serialVersionUID = 2377654559575631596L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	// 电影mid
	@Column(name="Mid")
	private String mid;
	// 用户账号
	@Column(name="UserCode")
	private String userCode;
	// 电影得分
	@Column(name="Score")
	private Integer score;
	
	
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
	
	public String getUserCode() {
		return userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public MovieScore setScore(Integer score) {
		this.score = score;
		return this;
	}

}

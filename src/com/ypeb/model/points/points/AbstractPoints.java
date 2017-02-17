package com.ypeb.model.points.points;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ypeb.model.points.pointsPublish.Pointspublish;

/**
 * AbstractPoints entity provides the base persistence definition of the Points
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractPoints implements java.io.Serializable {

	// Fields

	private Integer id;
	private Pointspublish pointspublish;
	private Integer userId;
	private Double pointNum;
	private Timestamp time;
	private Boolean state;
	private Boolean isDelete;
	private Integer releasedTime;
	private Integer releaseTime;

	// Constructors

	/** default constructor */
	public AbstractPoints() {
	}

	/** minimal constructor */
	public AbstractPoints(Pointspublish pointspublish, Integer userId,
			Double pointNum, Timestamp time, Boolean state, Integer releasedTime) {
		this.pointspublish = pointspublish;
		this.userId = userId;
		this.pointNum = pointNum;
		this.time = time;
		this.state = state;
		this.releasedTime = releasedTime;
	}

	/** full constructor */
	public AbstractPoints(Pointspublish pointspublish, Integer userId,
			Double pointNum, Timestamp time, Boolean state, Boolean isDelete,
			Integer releasedTime, Integer releaseTime) {
		this.pointspublish = pointspublish;
		this.userId = userId;
		this.pointNum = pointNum;
		this.time = time;
		this.state = state;
		this.isDelete = isDelete;
		this.releasedTime = releasedTime;
		this.releaseTime = releaseTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publishID", nullable = false)
	public Pointspublish getPointspublish() {
		return this.pointspublish;
	}

	public void setPointspublish(Pointspublish pointspublish) {
		this.pointspublish = pointspublish;
	}

	@Column(name = "userID", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "pointNum", nullable = false, precision = 11)
	public Double getPointNum() {
		return this.pointNum;
	}

	public void setPointNum(Double pointNum) {
		this.pointNum = pointNum;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "state", nullable = false)
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Column(name = "isDelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "releasedTime", nullable = false)
	public Integer getReleasedTime() {
		return this.releasedTime;
	}

	public void setReleasedTime(Integer releasedTime) {
		this.releasedTime = releasedTime;
	}

	@Column(name = "releaseTime")
	public Integer getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(Integer releaseTime) {
		this.releaseTime = releaseTime;
	}

}
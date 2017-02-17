package com.ypeb.model.points.release;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AbstractPointsrelease entity provides the base persistence definition of the
 * Pointsrelease entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractPointsrelease implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Double pointsNum;
	private Short releaseTime;
	private Date beginTime;
	private Short source;
	private Short releasedT;
	private Boolean isFinish;
	private String residue;

	// Constructors

	/** default constructor */
	public AbstractPointsrelease() {
	}

	/** full constructor */
	public AbstractPointsrelease(Integer userId, Double pointsNum,
			Short releaseTime, Date beginTime, Short source, Short releasedT,
			Boolean isFinish, String residue) {
		this.userId = userId;
		this.pointsNum = pointsNum;
		this.releaseTime = releaseTime;
		this.beginTime = beginTime;
		this.source = source;
		this.releasedT = releasedT;
		this.isFinish = isFinish;
		this.residue = residue;
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

	@Column(name = "userID", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "pointsNum", nullable = false, precision = 11)
	public Double getPointsNum() {
		return this.pointsNum;
	}

	public void setPointsNum(Double pointsNum) {
		this.pointsNum = pointsNum;
	}

	@Column(name = "releaseTime", nullable = false)
	public Short getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(Short releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "beginTime", nullable = false, length = 10)
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "source", nullable = false)
	public Short getSource() {
		return this.source;
	}

	public void setSource(Short source) {
		this.source = source;
	}

	@Column(name = "releasedT", nullable = false)
	public Short getReleasedT() {
		return this.releasedT;
	}

	public void setReleasedT(Short releasedT) {
		this.releasedT = releasedT;
	}

	@Column(name = "isFinish", nullable = false)
	public Boolean getIsFinish() {
		return this.isFinish;
	}

	public void setIsFinish(Boolean isFinish) {
		this.isFinish = isFinish;
	}

	@Column(name = "residue", nullable = false, length = 45)
	public String getResidue() {
		return this.residue;
	}

	public void setResidue(String residue) {
		this.residue = residue;
	}

}
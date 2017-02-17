package com.ypeb.model.points.pointsPublish;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ypeb.model.points.points.Points;

/**
 * AbstractPointspublish entity provides the base persistence definition of the
 * Pointspublish entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractPointspublish implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer operator;
	private Timestamp time;
	private Double totalNum;
	private Double residue;
	private Integer releaseTime;
	private Boolean state;
	private Set<Points> pointses = new HashSet<Points>(0);

	// Constructors

	/** default constructor */
	public AbstractPointspublish() {
	}

	/** minimal constructor */
	public AbstractPointspublish(Integer operator, Timestamp time,
			Double totalNum, Double residue, Integer releaseTime, Boolean state) {
		this.operator = operator;
		this.time = time;
		this.totalNum = totalNum;
		this.residue = residue;
		this.releaseTime = releaseTime;
		this.state = state;
	}

	/** full constructor */
	public AbstractPointspublish(Integer operator, Timestamp time,
			Double totalNum, Double residue, Integer releaseTime,
			Boolean state, Set<Points> pointses) {
		this.operator = operator;
		this.time = time;
		this.totalNum = totalNum;
		this.residue = residue;
		this.releaseTime = releaseTime;
		this.state = state;
		this.pointses = pointses;
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

	@Column(name = "operator", nullable = false)
	public Integer getOperator() {
		return this.operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "totalNum", nullable = false, precision = 11)
	public Double getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(Double totalNum) {
		this.totalNum = totalNum;
	}

	@Column(name = "residue", nullable = false, precision = 11)
	public Double getResidue() {
		return this.residue;
	}

	public void setResidue(Double residue) {
		this.residue = residue;
	}

	@Column(name = "releaseTime", nullable = false)
	public Integer getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(Integer releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Column(name = "state", nullable = false)
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pointspublish")
	public Set<Points> getPointses() {
		return this.pointses;
	}

	public void setPointses(Set<Points> pointses) {
		this.pointses = pointses;
	}

}
package com.ypeb.model.user.award;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractAward entity provides the base persistence definition of the Award
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractAward implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer getAwardId;
	private Short level;
	private Timestamp time;
	private Double num;
	private Integer sourceId;

	// Constructors

	/** default constructor */
	public AbstractAward() {
	}

	/** full constructor */
	public AbstractAward(Integer getAwardId, Short level, Timestamp time,
			Double num, Integer sourceId) {
		this.getAwardId = getAwardId;
		this.level = level;
		this.time = time;
		this.num = num;
		this.sourceId = sourceId;
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

	@Column(name = "getAwardID", nullable = false)
	public Integer getGetAwardId() {
		return this.getAwardId;
	}

	public void setGetAwardId(Integer getAwardId) {
		this.getAwardId = getAwardId;
	}

	@Column(name = "level", nullable = false)
	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "num", nullable = false, precision = 10)
	public Double getNum() {
		return this.num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	@Column(name = "sourceID", nullable = false)
	public Integer getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

}
package com.ypeb.model.points.setting;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractSetting entity provides the base persistence definition of the
 * Setting entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractSetting implements java.io.Serializable {

	// Fields

	private Integer id;
	private Double price;
	private Short month;
	private Short giveDays;
	private Short consumeDays;
	private Double withdrawRate;
	private Double firstAward;
	private Double secondAward;
	private Integer maxPoints;
	private Double feedbackAward;
	private Boolean isUsing;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public AbstractSetting() {
	}

	/** minimal constructor */
	public AbstractSetting(Double price, Short month, Short giveDays,
			Short consumeDays, Double withdrawRate, Double firstAward,
			Double secondAward, Integer maxPoints, Double feedbackAward,
			Boolean isDelete) {
		this.price = price;
		this.month = month;
		this.giveDays = giveDays;
		this.consumeDays = consumeDays;
		this.withdrawRate = withdrawRate;
		this.firstAward = firstAward;
		this.secondAward = secondAward;
		this.maxPoints = maxPoints;
		this.feedbackAward = feedbackAward;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public AbstractSetting(Double price, Short month, Short giveDays,
			Short consumeDays, Double withdrawRate, Double firstAward,
			Double secondAward, Integer maxPoints, Double feedbackAward,
			Boolean isUsing, Boolean isDelete) {
		this.price = price;
		this.month = month;
		this.giveDays = giveDays;
		this.consumeDays = consumeDays;
		this.withdrawRate = withdrawRate;
		this.firstAward = firstAward;
		this.secondAward = secondAward;
		this.maxPoints = maxPoints;
		this.feedbackAward = feedbackAward;
		this.isUsing = isUsing;
		this.isDelete = isDelete;
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

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "month", nullable = false)
	public Short getMonth() {
		return this.month;
	}

	public void setMonth(Short month) {
		this.month = month;
	}

	@Column(name = "giveDays", nullable = false)
	public Short getGiveDays() {
		return this.giveDays;
	}

	public void setGiveDays(Short giveDays) {
		this.giveDays = giveDays;
	}

	@Column(name = "consumeDays", nullable = false)
	public Short getConsumeDays() {
		return this.consumeDays;
	}

	public void setConsumeDays(Short consumeDays) {
		this.consumeDays = consumeDays;
	}

	@Column(name = "withdrawRate", nullable = false, precision = 22, scale = 0)
	public Double getWithdrawRate() {
		return this.withdrawRate;
	}

	public void setWithdrawRate(Double withdrawRate) {
		this.withdrawRate = withdrawRate;
	}

	@Column(name = "firstAward", nullable = false, precision = 22, scale = 0)
	public Double getFirstAward() {
		return this.firstAward;
	}

	public void setFirstAward(Double firstAward) {
		this.firstAward = firstAward;
	}

	@Column(name = "secondAward", nullable = false, precision = 22, scale = 0)
	public Double getSecondAward() {
		return this.secondAward;
	}

	public void setSecondAward(Double secondAward) {
		this.secondAward = secondAward;
	}

	@Column(name = "maxPoints", nullable = false)
	public Integer getMaxPoints() {
		return this.maxPoints;
	}

	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}

	@Column(name = "feedbackAward", nullable = false, precision = 22, scale = 0)
	public Double getFeedbackAward() {
		return this.feedbackAward;
	}

	public void setFeedbackAward(Double feedbackAward) {
		this.feedbackAward = feedbackAward;
	}

	@Column(name = "isUsing")
	public Boolean getIsUsing() {
		return this.isUsing;
	}

	public void setIsUsing(Boolean isUsing) {
		this.isUsing = isUsing;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}
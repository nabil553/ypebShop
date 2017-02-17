package com.ypeb.model.trade.pointsSale;

import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * AbstractPointssale entity provides the base persistence definition of the
 * Pointssale entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPointssale implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer saleId;
	private Timestamp time;
	private Double num;
	private Double price;
	private Double allPrice;
	private Short state;
	private Short residue;
	private Boolean selectAll;

	// Constructors

	/** default constructor */
	public AbstractPointssale() {
	}

	/** full constructor */
	public AbstractPointssale(Integer saleId, Timestamp time, Double num,
			Double price, Double allPrice, Short state, Short residue,
			Boolean selectAll) {
		this.saleId = saleId;
		this.time = time;
		this.num = num;
		this.price = price;
		this.allPrice = allPrice;
		this.state = state;
		this.residue = residue;
		this.selectAll = selectAll;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSaleId() {
		return this.saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Double getNum() {
		return this.num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAllPrice() {
		return this.allPrice;
	}

	public void setAllPrice(Double allPrice) {
		this.allPrice = allPrice;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Short getResidue() {
		return this.residue;
	}

	public void setResidue(Short residue) {
		this.residue = residue;
	}

	@Column(name = "selectAll", nullable = false)
	public Boolean getSelectAll() {
		return this.selectAll;
	}

	public void setSelectAll(Boolean selectAll) {
		this.selectAll = selectAll;
	}

}
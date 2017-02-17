package com.ypeb.model.trade.pointsBuy;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractPointsbuy entity provides the base persistence definition of the
 * Pointsbuy entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractPointsbuy implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer buyId;
	private Timestamp time;
	private Double price;
	private Double num;
	private Double allPrice;
	private Short state;
	private Double residue;

	// Constructors

	/** default constructor */
	public AbstractPointsbuy() {
	}

	/** full constructor */
	public AbstractPointsbuy(Integer buyId, Timestamp time, Double price,
			Double num, Double allPrice, Short state, Double residue) {
		this.buyId = buyId;
		this.time = time;
		this.price = price;
		this.num = num;
		this.allPrice = allPrice;
		this.state = state;
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

	@Column(name = "buyID", nullable = false)
	public Integer getBuyId() {
		return this.buyId;
	}

	public void setBuyId(Integer buyId) {
		this.buyId = buyId;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "price", nullable = false, precision = 5)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "num", nullable = false, precision = 11)
	public Double getNum() {
		return this.num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	@Column(name = "allPrice", nullable = false, precision = 12)
	public Double getAllPrice() {
		return this.allPrice;
	}

	public void setAllPrice(Double allPrice) {
		this.allPrice = allPrice;
	}

	@Column(name = "state", nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "residue", nullable = false, precision = 22, scale = 0)
	public Double getResidue() {
		return this.residue;
	}

	public void setResidue(Double residue) {
		this.residue = residue;
	}

}
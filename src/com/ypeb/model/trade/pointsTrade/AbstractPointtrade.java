package com.ypeb.model.trade.pointsTrade;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractPointtrade entity provides the base persistence definition of the
 * Pointtrade entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractPointtrade implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer saleId;
	private Integer buyId;
	private Double num;
	private Double price;
	private Double allprice;
	private Timestamp time;
	private Short iceTime;

	// Constructors

	/** default constructor */
	public AbstractPointtrade() {
	}

	/** full constructor */
	public AbstractPointtrade(Integer saleId, Integer buyId, Double num,
			Double price, Double allprice, Timestamp time, Short iceTime) {
		this.saleId = saleId;
		this.buyId = buyId;
		this.num = num;
		this.price = price;
		this.allprice = allprice;
		this.time = time;
		this.iceTime = iceTime;
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

	@Column(name = "saleID", nullable = false)
	public Integer getSaleId() {
		return this.saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	@Column(name = "buyID", nullable = false)
	public Integer getBuyId() {
		return this.buyId;
	}

	public void setBuyId(Integer buyId) {
		this.buyId = buyId;
	}

	@Column(name = "num", nullable = false, precision = 11)
	public Double getNum() {
		return this.num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	@Column(name = "price", nullable = false, precision = 11)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "allprice", nullable = false, precision = 12)
	public Double getAllprice() {
		return this.allprice;
	}

	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "iceTime", nullable = false)
	public Short getIceTime() {
		return this.iceTime;
	}

	public void setIceTime(Short iceTime) {
		this.iceTime = iceTime;
	}

}
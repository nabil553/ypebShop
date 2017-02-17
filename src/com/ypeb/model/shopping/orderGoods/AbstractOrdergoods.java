package com.ypeb.model.shopping.orderGoods;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractOrdergoods entity provides the base persistence definition of the
 * Ordergoods entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractOrdergoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer goodsId;
	private String goodsName;
	private Integer num;
	private Double unitPrice;
	private Double totalPrice;
	private Integer orderId;
	private String goodsImage;

	// Constructors

	/** default constructor */
	public AbstractOrdergoods() {
	}

	/** minimal constructor */
	public AbstractOrdergoods(Integer orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public AbstractOrdergoods(Integer goodsId, String goodsName, Integer num,
			Double unitPrice, Double totalPrice, Integer orderId,
			String goodsImage) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.num = num;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
		this.goodsImage = goodsImage;
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

	@Column(name = "goodsID")
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goodsName", length = 60)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "unitPrice", precision = 10)
	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "totalPrice", precision = 11)
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "orderID", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "goodsImage", length = 60)
	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

}
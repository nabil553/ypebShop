package com.ypeb.model.shopping.orderGoods;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ordergoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ordergoods", catalog = "ypeb")
public class Ordergoods extends AbstractOrdergoods implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Ordergoods() {
	}

	/** minimal constructor */
	public Ordergoods(Integer orderId) {
		super(orderId);
	}

	public Ordergoods(Integer goodsId, String goodsName, Integer num,
			Double unitPrice, Double totalPrice, Integer orderId,
			String goodsImage) {
		super(goodsId, goodsName, num, unitPrice, totalPrice, orderId, goodsImage);
		// TODO Auto-generated constructor stub
	}

	/** full constructor */
	

}

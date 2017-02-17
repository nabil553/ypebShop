package com.ypeb.model.shopping.goodsOrder;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order", catalog = "ypeb")
public class Order extends AbstractOrder implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Order() {
	}

	public Order(Integer id, Integer userId, Integer goodsId, Double unitPrice,
			Short num, Short state, Double totalprice, Integer address,
			Boolean style, String orderCode, Timestamp time,
			Boolean releaseState) {
		super(id, userId, goodsId, unitPrice, num, state, totalprice, address, style,
				orderCode, time, releaseState);
		// TODO Auto-generated constructor stub
	}

	

	

	/** full constructor */


}

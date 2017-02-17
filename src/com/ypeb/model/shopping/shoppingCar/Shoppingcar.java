package com.ypeb.model.shopping.shoppingCar;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Shoppingcar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shoppingcar", catalog = "ypeb")
public class Shoppingcar extends AbstractShoppingcar implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Shoppingcar() {
	}

	public Shoppingcar(Integer userId, Integer goodsId) {
		super(userId, goodsId);
		// TODO Auto-generated constructor stub
	}

	public Shoppingcar(Integer userId, Timestamp time, Integer goodsId,
			Integer num, Double price, Double allPrice) {
		super(userId, time, goodsId, num, price, allPrice);
		// TODO Auto-generated constructor stub
	}

	/** full constructor */
	

}
